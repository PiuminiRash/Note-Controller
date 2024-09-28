package lk.ijse.notecontrollerspring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecontrollerspring.Service.UserService;
import lk.ijse.notecontrollerspring.dao.UserDao;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public UserDto saveUser(UserDto userDto) {
        return mapping.toUserDto(
                userDao.save(
                        mapping.toUserEntity(userDto)
                )
        );
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
