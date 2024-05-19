package org.example.store.repository;

import org.example.store.model.Assortment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AssortmentRepository extends JpaRepository<Assortment, Long> {
    Assortment findById(long id);
}
