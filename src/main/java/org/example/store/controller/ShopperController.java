//package org.example.store.controller;
//
//import org.example.store.model.Shopper;
//import org.example.store.services.ShopperServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/shoppers")
//public class ShopperController {
//
//    @Autowired
//    private ShopperServices shopperService;
//
//    @GetMapping()
//    public String shoppers(Model model) {
//        List<Shopper> shoppers = shopperService.getAllShoppers(StoreType.valueOf(storeType), id, Enums.ProductType.valueOf(productType), productId);
//        model.addAttribute("shoppers", shoppers);
//        return "shopper/names";
//    }
//
//    @GetMapping("/{shopper_id}")
//    public String shopperById(@PathVariable("shopper_id") int shopperId, Model model) {
//        Shopper shopper = shopperService.getShopperById(shopperId);
//        model.addAttribute("shopper", shopper);
//        return "shopper/id";
//    }
//
//    @GetMapping("/new")
//    public String newShopper(Model model) {
//        Shopper shopper = new Shopper();
//        model.addAttribute("shopper", shopper);
//        return "shopper/new";
//    }
//
//    @PostMapping("")
//    public String saveShopper(@ModelAttribute("shopper") Shopper shopper, Model model) {
//        shopperService.addShopper(shopper);
//        List<Shopper> shoppers = shopperService.getAllShoppers(Enums.StoreType.valueOf(storeType), id, Enums.ProductType.valueOf(productType), productId);
//        model.addAttribute("shoppers", shoppers);
//        return "shopper/names";
//    }
//
//    @GetMapping("/{shopper_id}/edit")
//    public String editShopper(@PathVariable("shopper_id") int shopperId, Model model) {
//        Shopper shopper = shopperService.getShopperById(shopperId);
//        model.addAttribute("shopper", shopper);
//        return "shopper/edit";
//    }
//
//    @PatchMapping("/{shopper_id}")
//    public String updateShopper(@ModelAttribute("shopper") Shopper shopper, @PathVariable("store_type") String storeType,
//                                @PathVariable("id") int id, Model model, @PathVariable("shopper_id") int shopperId,
//                                @PathVariable("product_type") String productType, @PathVariable("product_id") int productId) {
//        shopper.setId(shopperId);
//        shopperService.updateShopper(shopper);
//        model.addAttribute("shopper", shopper);
//        model.addAttribute("store_type", Enums.StoreType.valueOf(storeType));
//        model.addAttribute("id", id);
//        model.addAttribute("product_type", Enums.ProductType.valueOf(productType));
//        model.addAttribute("product_id", productId);
//        return "shopper/id";
//    }
//
//    @DeleteMapping("/{shopper_id}")
//    public String deleteShopper(@PathVariable("store_type") String storeType, @PathVariable("id") int id,
//                                @PathVariable("shopper_id") int shopperId, Model model,
//                                @PathVariable("product_type") String productType, @PathVariable("product_id") int productId) {
//        shopperService.deleteShopper(shopperId);
//        List<Shopper> shoppers = shopperService.getAllShoppers(Enums.StoreType.valueOf(storeType), id, Enums.ProductType.valueOf(productType), productId);
//        model.addAttribute("shoppers", shoppers);
//        model.addAttribute("store_type", Enums.StoreType.valueOf(storeType));
//        model.addAttribute("id", id);
//        model.addAttribute("product_type", Enums.ProductType.valueOf(productType));
//        model.addAttribute("product_id", productId);
//        return "shopper/names";
//    }
//}
