package lk.ijse.notecontrollerspring.CustomeStatusCodes;

import lk.ijse.notecontrollerspring.dto.UserStatus;
import lk.ijse.notecontrollerspring.dto.impl.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedUserAndNoteErrorStatus implements UserStatus , NoteStatus {
    private int statusCode;
    private String status;
}

