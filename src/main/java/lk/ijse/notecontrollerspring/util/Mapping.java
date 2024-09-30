package lk.ijse.notecontrollerspring.util;

import lk.ijse.notecontrollerspring.dto.impl.NoteDto;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.entity.Impl.NoteEntity;
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

    //for note mapping
    public NoteDto toNoteDto(NoteEntity noteEntity) {
        return modelMapper.map(noteEntity, NoteDto.class);
    }
    public NoteEntity toNoteEntity(NoteDto noteDTO) {
        return modelMapper.map(noteDTO, NoteEntity.class);
    }
    public List<NoteDto> asNoteDtoList(List<NoteEntity> noteEntities) {
        return modelMapper.map(noteEntities, new TypeToken<List<NoteDto>>() {}.getType());
    }
}
