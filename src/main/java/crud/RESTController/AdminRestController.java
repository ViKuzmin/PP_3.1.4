package crud.RESTController;

import crud.exceptionhanling.UserIncorrectData;
import crud.exceptionhanling.UserNotFoundException;
import crud.models.User;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/users")
    //@GetMapping
    public List<User> showAll() {
        List<User> userList = userService.findAll();
        return  userList;
    }

    @GetMapping("/users/{id}")
    //@GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        User user = userService.findById(id);

        if(user.getId() == null) {
            throw new UserNotFoundException(String.format("User with id %s not exists.", id));
        }
        return user;
    }

    @PostMapping("/users")
    //@PostMapping
    public User addUser(@RequestBody User user) {

        userService.save(user);
        return user;
    }

    @PutMapping("/users")
    //@PutMapping
    public User updateUser(@RequestBody User user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {

        User user = userService.findById(id);

        if(user.getId() == null) {
            throw new UserNotFoundException(String.format("User with id %s not exists", id));
        }

        userService.delete(id);
        return String.format("User with id %s deleted", id);
    }
}
