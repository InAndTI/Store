package org.example.store.services;

import org.example.store.model.Assortment;
import org.example.store.enums.ProductType;
import org.example.store.enums.StoreType;
import org.example.store.repository.AssortmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssortmentServices {
    @Autowired
    private AssortmentRepository assortmentRepository;

    public void addBuy(Assortment assortment) {
        assortmentRepository.save(assortment);
    }

    public void updateBuy(Assortment assortment) {
        assortmentRepository.save(assortment);
    }

    public void deleteBuy(long assortmentId) {
        assortmentRepository.deleteById(assortmentId);
    }

    public Assortment getBuyById(long id) {
        return assortmentRepository.findById(id);
    }

    public List<Assortment> getAllBuys(StoreType storeType, int storeId, ProductType productType, int productId, int shopperId) {
        return assortmentRepository.findAll();
    }
}
