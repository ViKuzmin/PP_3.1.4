package crud.controller;

import crud.models.Role;
import crud.models.User;
import crud.repository.UsersRepository;
import crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/reg")
    public String reg() {

        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model) {

        User userFromDB = userService.findByUsername(user.getUsername());

        if (userFromDB != null) {
            model.put("message", "User already exists");
            return "reg";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        userService.save(user);

        return "redirect:login";
    }
}
