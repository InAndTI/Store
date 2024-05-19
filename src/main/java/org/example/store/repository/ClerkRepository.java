package org.example.store.repository;

import org.example.store.model.Clerk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClerkRepository extends JpaRepository<Clerk, Long> {
    Clerk findById(long id);
}
