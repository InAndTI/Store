package org.example.store.controller;

import lombok.RequiredArgsConstructor;
import org.example.store.model.Store;
import org.example.store.enums.StoreType;
import org.example.store.services.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private final StoreServices storeService;
    @GetMapping("/type")
    public String storeType(Model model) {
        List<String> types = new ArrayList<>();
        types.add("ALL");
        types.add("DEPARTMENT");
        types.add("STORE");
        types.add("KIOSK");
        types.add("TRAY");
        model.addAttribute("types", types);
        return "store/type";
    }
    @GetMapping("/{store_type}")
    public String Type(@PathVariable("store_type") String store_type, Model model){
        List<Store> stores = storeService.getAllStores(StoreType.valueOf(store_type));
        model.addAttribute("stores", stores);
        model.addAttribute("types", StoreType.valueOf(store_type));
        return "store/names";
    }
    @GetMapping("/{store_type}/{id}")
    public String nameStore(Model model, @PathVariable("id") int id, @PathVariable("store_type") String store_type){
        if(id>0) {
            Store store = storeService.getStoreById(id);
            model.addAttribute("store", store);
            model.addAttribute("types", StoreType.valueOf(store_type));
            return "store/id";
        }
        model.addAttribute("id", -1);
        model.addAttribute("types", StoreType.valueOf(store_type));
        return "store/all";
    }
    @GetMapping("/{store_type}/{id}/inf")
    public String infNameStore(Model model, @PathVariable("id") int id, @PathVariable("store_type") String store_type){
        if(id>0) {
            Store store = storeService.getStoreById(id);
            model.addAttribute("store", store);
            model.addAttribute("types", StoreType.valueOf(store_type));
        }
        return "store/inf";
    }
    @GetMapping("/new")
    public String newStore(Model model){
        Store store = new Store();
        model.addAttribute("store", store);
        return "store/new";
    }
    @PostMapping()
    public String saveStore(@ModelAttribute("store") Store store, Model model){
        storeService.addStore(store);
        List<Store> stores = storeService.getAllStores(StoreType.valueOf("ALL"));
        model.addAttribute("stores", stores);
        return "store/names";
    }
    @GetMapping("/{id}/edit")
    public String editStore(@PathVariable("id") int id, Model model){
        Store store = storeService.getStoreById(id);
        model.addAttribute("store", store);
        return "store/edit";
    }
    @PatchMapping("/{id}")
    public String updateStore(@ModelAttribute("store") Store store, Model model){
        storeService.updateStore(store);
        model.addAttribute("store", store);
        return "store/inf";
    }
    @DeleteMapping("/{id}")
    public String deleteStore(@PathVariable("id") int id, Model model){
        storeService.deleteStore(id);
        List<Store> stores = storeService.getAllStores(StoreType.valueOf("ALL"));
        model.addAttribute("stores", stores);
        return "store/names";
    }

}
