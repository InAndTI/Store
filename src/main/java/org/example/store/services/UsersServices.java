package org.example.store.services;

import lombok.AllArgsConstructor;
import org.example.store.model.Users;
import org.example.store.enums.Role;
import org.example.store.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UsersServices {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public boolean addUser(Users user) {
        System.out.println(user);
        if(usersRepository.findByEmail(user.getEmail()) != null){
            return false;
        }else {
            System.out.println(22);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRole().add(Role.USER);
            System.out.println(user.getRole());
            usersRepository.save(user);
            return true;
        }
    }
    public void updateUser(Users user) {usersRepository.save(user);}
    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }
    public Users getUserById(long id) {
        return usersRepository.findById(id);
    }
    public List<Users> getAll(Role role) {
        if(role.equals(Role.ALL)) {
            return usersRepository.findAll();
        }
        return usersRepository.findAllByRole(role);
    }
}
