package org.example.store.services;

import org.example.store.model.Store;
import org.example.store.enums.StoreType;
import org.example.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServices {
    @Autowired
    private StoreRepository storeRepository;

    public void addStore(Store store) {
        storeRepository.save(store);
    }
    public void updateStore(Store store) {
        storeRepository.save(store);
    }
    public void deleteStore(long id) {
        storeRepository.deleteById(id);
    }
    public Store getStoreById(int id) {
        return storeRepository.findById(id);
    }
    public List<Store> getAllStores(StoreType storeType) {
        if(storeType.equals(StoreType.ALL)) {
            return storeRepository.findAll();
        }
        return storeRepository.findAllByTypeStore(storeType);
    }
}
