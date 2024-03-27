package dev.javarush.hackathon.ordermanagement.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getAll() {
        return this.userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") Integer id) {
        return this.userService.getUserById(id);
    }

}
