package org.example.store.services;

import org.example.store.model.Clerk;
import org.example.store.enums.StoreType;
import org.example.store.repository.ClerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClerkServices {
    @Autowired
    private ClerkRepository clerkRepository;

    public void addClerk(Clerk clerk) {
        clerkRepository.save(clerk);
    }
    public void updateClerk(Clerk clerk) {
        clerkRepository.save(clerk);
    }
    public void deleteClerk(long id) {
        clerkRepository.deleteById(id);
    }
    public Clerk getClerkById(long id) {
        return clerkRepository.findById(id);
    }
    public List<Clerk> getAllClerks(StoreType storeType, int storeId) {
        return clerkRepository.findAll();
    }
}
