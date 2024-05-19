package org.example.store.repository;

import org.example.store.model.Users;
import org.example.store.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findById(long id);
    List<Users> findAllByRole(Role role);
    Users findByEmail(String email);
}
