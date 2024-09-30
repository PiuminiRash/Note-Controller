package lk.ijse.notecontrollerspring.controller;

import lk.ijse.notecontrollerspring.Service.UserService;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.util.AppUtil;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.Line;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public  UserDto saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePic") String profilePic
    ) {
        //todo: ProfilePic---->Base64
        System.out.println("RAW pro pic"+profilePic);
        String base64proPic = "";
//        String base64proPic = AppUtil.profilePicToBase64(profilePic);

        try {
            byte[] bytesProPic = profilePic.getBytes();
            base64proPic = AppUtil.profilePicToBase64(bytesProPic);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //todo: Set generate Id
        String userId = AppUtil.generateUserId();

        //todo: Build the object
        var buildUserDto = new UserDto();
        buildUserDto.setUserId(userId);
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
//        buildUserDto.setProfilePic(profilePic);
        buildUserDto.setProfilePic(profilePic);

        userService.saveUser(buildUserDto);

        return buildUserDto;
    }

    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getSelectedUser(@PathVariable ("userId") String userId) {
        return userService.getUser(userId);
    }

    @ResponseStatus (HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable ("userId") String userId) {
        userService.deleteUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateUser(
            @RequestPart ("firstName") String firstName,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilePic") MultipartFile profilePic,
            @PathVariable ("userId") String userId
    ){
        // profilePic ----> Base64
        String base64ProPic = "";
        try {
            byte [] bytesProPic = profilePic.getBytes();
            base64ProPic = AppUtil.profilePicToBase64(bytesProPic);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Build the Object
        UserDto buildUserDTO = new UserDto();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        userService.updateUser(userId,buildUserDTO);
    }
}
