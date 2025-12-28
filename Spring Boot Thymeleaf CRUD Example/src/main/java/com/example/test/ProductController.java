package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


//    @GetMapping("/new")
//    public String showForm(Model model) {
//        // 1. Add the list of options to populate the combo box
//        Model countryList = model.addAttribute("countryList", new Product().getCountry());
//
//        return "formTemplateObject";
//    }

    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("countryList", new Product().getCountry());
        model.addAttribute("isEdit", true);
        return "form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        //model.addAttribute("country", new Product().getCountry());
       // model.addAttribute("countryList", new Product().getCountry());
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }
}



