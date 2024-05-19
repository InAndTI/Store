package org.example.store.repository;

import org.example.store.model.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper, Long> {
    Shopper findById(long id);
}
