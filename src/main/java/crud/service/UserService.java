package crud.service;

import crud.models.User;

import java.util.List;

public interface UserService {

    User findById(Long userId);

    List<User> findAll();

    boolean save(User user);

    boolean delete(Long userId);

    List<User> usergetList(Long idMin);

   // void updateUser(long id, User user);
}
