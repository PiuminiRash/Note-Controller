package lk.ijse.notecontrollerspring.Service;

import lk.ijse.notecontrollerspring.dto.UserStatus;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserStatus getUser(String userId);
    void deleteUser(String userId);
    void updateUser(String userId,UserDto userDto);
}
