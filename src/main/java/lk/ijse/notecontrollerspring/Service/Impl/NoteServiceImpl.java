package lk.ijse.notecontrollerspring.Service.Impl;

import lk.ijse.notecontrollerspring.Service.NoteService;
import lk.ijse.notecontrollerspring.dto.impl.NoteDto;
import lk.ijse.notecontrollerspring.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private static List<NoteDto> noteDtoList = new ArrayList<>();

    NoteServiceImpl(){
        noteDtoList.add(new NoteDto());
    }

    @Override
    public NoteDto saveNote(NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.generateNoteId());
        return noteDto;
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return noteDtoList;
    }

    @Override
    public NoteDto getNote(String noteId) {
        return null;
    }

    @Override
    public NoteDto SelectId() {
        return null;
    }

    @Override
    public void deleteNote(String noteId) {
    }

    @Override
    public void updateNote(String noteId, NoteDto noteDto) {
    }
}
