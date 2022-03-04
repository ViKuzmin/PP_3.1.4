package crud.repository;

import crud.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}
