package com.example.bt5.controller;


import com.example.bt5.models.Product;
import com.example.bt5.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/products")

    public class ProductController {
        @Autowired
        private ProductService productService;

        @GetMapping("/create")
        public String create(Model model)
        {
            model.addAttribute("product", new Product());
            return "products/create";
        }
        @GetMapping("")
        public String index(Model model)
        {
            model.addAttribute("listproduct", productService.GetAll());
            return "products/index";
        }

        @PostMapping("/create")
        public String create(@Valid Product newProduct,
                             @RequestParam  MultipartFile imageProduct,
                             BindingResult result,
                             Model model)
        {
            if (result.hasErrors())
            {
                model.addAttribute("product", newProduct);
                return "products/create";
            }


            if (imageProduct != null && !imageProduct.isEmpty()) {
                try {
                    File saveFile = new ClassPathResource("images").getFile();
                    String newImageFile = UUID.randomUUID() + ".png";
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                    Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    newProduct.setImage(newImageFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            productService.add(newProduct);
            return "redirect:/products";
        }


}


