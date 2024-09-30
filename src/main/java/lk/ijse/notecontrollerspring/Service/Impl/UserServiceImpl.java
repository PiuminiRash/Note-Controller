package lk.ijse.notecontrollerspring.Service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecontrollerspring.CustomeStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.notecontrollerspring.Exceptions.DataPersistentException;
import lk.ijse.notecontrollerspring.Exceptions.UserNotFoundException;
import lk.ijse.notecontrollerspring.Service.UserService;
import lk.ijse.notecontrollerspring.dao.UserDao;
import lk.ijse.notecontrollerspring.dto.UserStatus;
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
    private Mapping mapping;

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(UserDto userDto) {
        UserEntity savedUser =
                userDao.save(mapping.toUserEntity(userDto));
        if (savedUser == null) {
            throw new DataPersistentException("User not saved");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDtoList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDao.existsById(userId)){
            UserEntity selectedUser = userDao.getReferenceById(userId);
            return mapping.toUserDto(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2, "User with id " + userId + " not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existUser = userDao.findById(userId);
        if (!existUser.isPresent()) {
            throw new UserNotFoundException("user with id " + userId + "not found");
        } else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDto userDto) {
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDto.getFirstName());
            tmpUser.get().setLastName(userDto.getLastName());
            tmpUser.get().setEmail(userDto.getEmail());
            tmpUser.get().setPassword(userDto.getPassword());
            tmpUser.get().setProfilePic(userDto.getProfilePic());
        }
    }
}
