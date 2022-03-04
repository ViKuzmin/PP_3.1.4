package crud.service;

import crud.models.UserEntity;
import crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {


    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public UserEntity findById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public List<UserEntity> findAll() {
        return usersRepository.findAll();
    }

    public void save(UserEntity user) {
        usersRepository.save(user);
    }

    public void delete(Long id) {
        usersRepository.delete(findById(id));
    }
}
