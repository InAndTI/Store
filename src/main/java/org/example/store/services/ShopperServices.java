package org.example.store.services;

import org.example.store.model.Shopper;
import org.example.store.enums.ProductType;
import org.example.store.enums.StoreType;
import org.example.store.repository.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopperServices {
    @Autowired
    private ShopperRepository shopperRepository;

    public void addShopper(Shopper shopper) {
        shopperRepository.save(shopper);
    }
    public void updateShopper(Shopper shopper) {shopperRepository.save(shopper);}
    public void deleteShopper(Long shopperId) {
        shopperRepository.deleteById(shopperId);
    }
    public Shopper getShopperById(long id) {
        return shopperRepository.findById(id);
    }
    public List<Shopper> getAllShoppers(StoreType storeType, int storeId, ProductType productType, int productId) {
        return shopperRepository.findAll();
    }
}
