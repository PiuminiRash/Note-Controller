package lk.ijse.notecontrollerspring.Service;

import lk.ijse.notecontrollerspring.dto.impl.NoteDto;
import lk.ijse.notecontrollerspring.dto.NoteStatus;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDto noteDto);
    List<NoteDto> getAllNotes();
    NoteStatus getNote(String noteId);
    void deleteNote(String noteId);
    boolean updateNote(String noteId, NoteDto noteDto);
}
