package lk.ijse.notecontrollerspring.controller;

import lk.ijse.notecontrollerspring.Service.UserService;
import lk.ijse.notecontrollerspring.dto.impl.UserDto;
import lk.ijse.notecontrollerspring.util.AppUtil;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            @RequestPart("profilePic") MultipartFile profilePic
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

        return buildUserDto;
    }
}
