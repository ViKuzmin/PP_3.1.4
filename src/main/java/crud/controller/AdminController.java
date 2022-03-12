package crud.controller;

import crud.models.Role;
import crud.models.User;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

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
        Role roleUser = new Role(1L, "ROLE_USER");
        Role roleAdmin = new Role(2L, "ROLE_ADMIN");

        /*Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        roles.add(roleAdmin);*/

        model.addAttribute("users", userServiceImpl.findAll());
        model.addAttribute("authUser", autUser);
        model.addAttribute("user", user);
       // model.addAttribute("roles", roles);
        model.addAttribute("roleUser", roleUser);
        model.addAttribute("roleAdmin", roleAdmin);
        return "admin";
    }

    /*@GetMapping("/new")
    public String addUserView(@ModelAttribute("user") User user) {
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String updateUserPage(Model model, @PathVariable long id) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "edit";
    }*/

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
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
