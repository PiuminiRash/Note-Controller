package lk.ijse.notecontrollerspring.entity.Impl;

import jakarta.persistence.*;
import lk.ijse.notecontrollerspring.entity.SuperEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="note")
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createdDate;
    private String priorityLevel;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
}
