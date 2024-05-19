package org.example.store.services;

import org.example.store.model.Buy;
import org.example.store.enums.StoreType;
import org.example.store.enums.ProductType;
import org.example.store.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyServices {
    @Autowired
    private BuyRepository buyRepository;

    public void addBuy(Buy buy) {
        buyRepository.save(buy);
    }

    public void updateBuy(Buy buy) {
        buyRepository.save(buy);
    }

    public void deleteBuy(long buyId) {
        buyRepository.deleteById(buyId);
    }

    public Buy getBuyById(long id) {
        return buyRepository.findById(id);
    }

    public List<Buy> getAllBuys(StoreType storeType, int storeId, ProductType productType, int productId, int shopperId) {
        return buyRepository.findAll();
    }
}













