package org.example.store.controller;

import org.example.store.model.Users;
import org.example.store.enums.Role;
import org.example.store.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersServices usersServices;
    @GetMapping("/role")
    public String getRole(Model model) {
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        roles.add("ADMIN");
        roles.add("MODERATOR");
        roles.add("ALL");
        model.addAttribute("roles", roles);
        return "users/roles";
    }
    @GetMapping("/role/{role}")
    public String users(@PathVariable("role") String role, Model model) {
        List<Users> users = usersServices.getAll(Role.valueOf(role));
        model.addAttribute("users", users);
        return "users/role";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        usersServices.getUserById(id);
        model.addAttribute("user", usersServices.getUserById(id));
        return "users/id";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "users/new";
    }
    @PostMapping()
    public String addUser(@ModelAttribute("user") Users user, Model model) {
        System.out.println(11);
        usersServices.addUser(user);
        List<Users> users = usersServices.getAll(Role.ALL);
        model.addAttribute("users", users);
        return "users/role";
    }
    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        Users user = usersServices.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") Users user, Model model) {
        System.out.println(1);
        usersServices.updateUser(user);
        System.out.println(2);
        model.addAttribute("user", user);
        return "users/id";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        usersServices.deleteUser(id);
        List<Users> users = usersServices.getAll(Role.ALL);
        model.addAttribute("users", users);
        return "users/role";
    }
}
