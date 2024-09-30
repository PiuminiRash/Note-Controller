package lk.ijse.notecontrollerspring.dao;

import lk.ijse.notecontrollerspring.entity.Impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository<NoteEntity,String> {

}
