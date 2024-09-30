package lk.ijse.notecontrollerspring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecontrollerspring.Service.UserService;
import lk.ijse.notecontrollerspring.dao.UserDao;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.entity.Impl.UserEntity;
import lk.ijse.notecontrollerspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDtoList(allUsers);
    }

    @Override
    public UserDto getUser(String userId) {
        UserEntity selectedUser = userDao.getReferenceById(userId);
        return mapping.toUserDto(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteById(userId);
    }

    @Override
    public void updateUser(String userId, UserDto userDto) {
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if (tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDto.getFirstName());
            tmpUser.get().setLastName(userDto.getLastName());
            tmpUser.get().setEmail(userDto.getEmail());
            tmpUser.get().setPassword(userDto.getPassword());
            tmpUser.get().setProfilePic(userDto.getProfilePic());
        }
    }
}
