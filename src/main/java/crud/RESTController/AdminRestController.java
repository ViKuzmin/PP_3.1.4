package crud.RESTController;

import crud.exceptionhanling.UserNotFoundException;
import crud.models.User;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserServiceImpl userService;

    @Autowired
    public AdminRestController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    //public List<User> showAll() {
    public ResponseEntity<List<User>> showAll() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    //@GetMapping("/{id}")
    //public User getUserById(@PathVariable long id) {
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.findById(id);

        if (user.getId() == null) {
            throw new UserNotFoundException(String.format("User with id %s not exists.", id));
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    //@PostMapping
    //public User addUser(@RequestBody User user) {
    public ResponseEntity<User> addUser(@RequestBody User user) {


        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/users")
    //public User addUser(@RequestBody User user) {
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    //public String deleteUser(@PathVariable long id) {
    public ResponseEntity<String> deleteUser(@PathVariable long id) {

        User user = userService.findById(id);

        if (user.getId() == null) {
            throw new UserNotFoundException(String.format("User with id %s not exists", id));
        }

        userService.delete(id);
        return new ResponseEntity<>(String.format("User with id %s deleted", id), HttpStatus.OK);
    }
}
