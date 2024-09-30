package lk.ijse.notecontrollerspring.dto.impl;

import lk.ijse.notecontrollerspring.dto.UserStatus;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserStatus {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteDto> noteId;
}
