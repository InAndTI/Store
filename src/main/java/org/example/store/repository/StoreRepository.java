package org.example.store.repository;

import org.example.store.model.Store;
import org.example.store.enums.StoreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findById(long id);
    List<Store> findAllByTypeStore(StoreType storeType);
}
