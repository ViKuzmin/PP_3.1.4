package crud.controller;

import crud.models.Role;
import crud.models.User;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getAllUsers(Model model) {

        User autUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();

        model.addAttribute("users", userServiceImpl.findAll());
        model.addAttribute("authUser", autUser);
        model.addAttribute("user", user);
        model.addAttribute("availableRoles", Role.getRole());

        return "admin";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable long id) {
        userServiceImpl.update(user, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userServiceImpl.delete(id);
        return "redirect:/admin";
    }
}
