package lk.ijse.notecontrollerspring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecontrollerspring.Service.UserService;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUser(String userId) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updateUser(String userId, UserDto userDto) {
        return false;
    }
}
