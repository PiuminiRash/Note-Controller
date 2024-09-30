package lk.ijse.notecontrollerspring.CustomeStatusCodes;

import lk.ijse.notecontrollerspring.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedUserErrorStatus implements UserStatus {
    private int statusCode;
    private String status;
}

