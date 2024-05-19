package org.example.store.services;

import org.example.store.enums.StoreType;
import org.example.store.enums.ProductType;
import org.example.store.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.store.model.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServices {
    @Autowired
    private ProviderRepository providerRepository;

//    public ProviderServices(ProviderRepository providerRepository) {
//        this.providerRepository = providerRepository;
//    }

    public void addProvider(Provider provider) {
        providerRepository.save(provider);
    }

    public void updateProvider(Provider provider) {providerRepository.save(provider);}

    public void deleteProvider(long providerId) {
        providerRepository.deleteById(providerId);
    }

    public Provider getProviderById(long id) {
        return providerRepository.findById(id);
    }

    public List<Provider> getAllProviders(StoreType storeType, int storeId, ProductType productType, int productId) {
        return providerRepository.findAll();
    }
}
















