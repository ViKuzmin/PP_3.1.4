package crud.controller;

import crud.models.User;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//@PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "admin";
    }

    @GetMapping("/new")
    public String addUserView(@ModelAttribute("user") User user) {
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String updateUserPage(Model model, @PathVariable long id) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "edit";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/admin";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable long id) {
        userServiceImpl.save(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userServiceImpl.delete(id);
        return "redirect:/admin";
    }
}
