package lk.ijse.notecontrollerspring.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateNoteId(){
        return "Note"+ UUID.randomUUID();
    }
    public static String generateUserId(){
        return "User"+ UUID.randomUUID();
    }

    public static String profilePicToBase64(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
    /*public static int count= 0;

    public static String generateId(){
        count++;
        return String.format("Note-%03d",count);
    }*/
}
