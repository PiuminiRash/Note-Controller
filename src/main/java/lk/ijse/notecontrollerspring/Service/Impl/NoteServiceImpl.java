package lk.ijse.notecontrollerspring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecontrollerspring.CustomeStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.notecontrollerspring.Exceptions.DataPersistentException;
import lk.ijse.notecontrollerspring.Exceptions.NoteNotFoundException;
import lk.ijse.notecontrollerspring.Service.NoteService;
import lk.ijse.notecontrollerspring.dao.NoteDao;
import lk.ijse.notecontrollerspring.dto.impl.NoteDto;
import lk.ijse.notecontrollerspring.dto.impl.NoteStatus;
import lk.ijse.notecontrollerspring.entity.Impl.NoteEntity;
import lk.ijse.notecontrollerspring.util.AppUtil;
import lk.ijse.notecontrollerspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    @Autowired
    private Mapping noteMapping;

    @Override
    public void saveNote(NoteDto noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        NoteEntity  savedNote =
                noteDao.save(noteMapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistentException("Note not saved");
        }
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return null;
    }

    @Override
    public NoteStatus getNote(String noteId) {
        if(noteDao.existsById(noteId)){
            var selectedUser = noteDao.getReferenceById(noteId);
            return noteMapping.toNoteDto(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2,"Selected note not found");
        }
    }

    @Override
    public void deleteNote(String noteId) {
        Optional<NoteEntity> foundNote = noteDao.findById(noteId);
        if (!foundNote.isPresent()) {
            throw new NoteNotFoundException("Note not found");
        }else {
            noteDao.deleteById(noteId);
        }
    }

    @Override
    public boolean updateNote(String noteId, NoteDto noteDTO) {
        return false;
    }
}
