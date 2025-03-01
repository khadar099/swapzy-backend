package com.swapzy.controller;

import com.swapzy.model.Product;
import com.swapzy.model.User;
import com.swapzy.repository.ProductRepository;
import com.swapzy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sell")
    public String showSellPage(Model model) {
        model.addAttribute("product", new Product());
        return "sell";
    }

    @PostMapping("/sell")
    public String uploadProduct(Product product, Model model) {
        User user = userRepository.findByUsername("loggedInUsername"); // Replace with actual logged-in user
        product.setUser(user);
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
}
