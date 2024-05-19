package org.example.store.services;

import org.example.store.model.Delivery;
import org.example.store.enums.StoreType;
import org.example.store.enums.ProductType;
import org.example.store.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServices {
    @Autowired
    private DeliveryRepository deliveryRepository;
    public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public void updateDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public void deleteDelivery(long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }

    public Delivery getDeliveryById(long id) {
        return deliveryRepository.findById(id);
    }

    public List<Delivery> getAllDeliveries(StoreType storeType, int storeId, ProductType productType, int productId, int providerId) {
        return deliveryRepository.findAll();
    }
}


















