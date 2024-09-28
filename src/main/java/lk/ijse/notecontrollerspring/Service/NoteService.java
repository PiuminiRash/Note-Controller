package lk.ijse.notecontrollerspring.Service;

import lk.ijse.notecontrollerspring.dto.impl.NoteDto;

import java.util.List;

public interface NoteService {
    NoteDto saveNote(NoteDto noteDto);
    List<NoteDto> getAllNotes();
    NoteDto getNote(String noteId);
    NoteDto SelectId();
    void deleteNote(String noteId);
    void updateNote(String noteId, NoteDto noteDto);
}
