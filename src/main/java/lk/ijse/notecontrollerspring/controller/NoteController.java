package lk.ijse.notecontrollerspring.controller;

import lk.ijse.notecontrollerspring.Service.NoteService;
import lk.ijse.notecontrollerspring.dto.impl.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)

    public NoteDto saveNote(@RequestBody NoteDto noteDto){
       return noteService.saveNote(noteDto);
    }

    public NoteDto getSelectedNote(){
        return null;
    }

    public List<NoteDto> getAllNotes(){
        return noteService.getAllNotes();
    }

    public void deleteNote(String noteId, NoteDto noteDto){

    }

    public void updateNote(String noteId, NoteDto noteDto){

    }
}
