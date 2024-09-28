package lk.ijse.notecontrollerspring.entity.Impl;

import jakarta.persistence.*;
import lk.ijse.notecontrollerspring.entity.SuperEntity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String profilePic;
    @OneToMany(mappedBy = "user")
    private List<NoteEntity> noteId;
}
