package lk.ijse.notecontrollerspring.util;

import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.entity.Impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //for user mapping
    public UserEntity toUserEntity(UserDto userDto) {
        return modelMapper.map(userDto,UserEntity.class);
    }

    public UserDto toUserDto(UserEntity userEntity) {
        return modelMapper.map(userEntity,UserDto.class);
    }
}
