package lk.ijse.notecontrollerspring.util;

import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.entity.Impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<UserDto> asUserDtoList(List<UserEntity> userEntityList) {
        return modelMapper.map(userEntityList,new TypeToken<List<UserDto>>(){}.getType());
    }
}
