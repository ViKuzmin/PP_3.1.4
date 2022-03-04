package crud.controller;

import crud.models.UserEntity;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UsersController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String addUserView(@ModelAttribute("user") UserEntity user) {
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String updateUserPage(Model model, @PathVariable long id) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "edit";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") UserEntity user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute UserEntity user, @PathVariable long id) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
}
