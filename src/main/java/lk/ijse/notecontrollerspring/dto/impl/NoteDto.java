package lk.ijse.notecontrollerspring.dto.impl;

import lk.ijse.notecontrollerspring.dto.SuperDto;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto implements NoteStatus {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createdDate;
    private String priorityLevel;
    private String userId;
}
