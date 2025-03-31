package com.learning.ecommerce1.config;

import com.learning.ecommerce1.model.Category;
import com.learning.ecommerce1.model.Product;
import com.learning.ecommerce1.repository.CategoryRepository;
import com.learning.ecommerce1.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Clear all existing data
        categoryRepository.deleteAll();
        productRepository.deleteAll();


        //Create Categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home");

        categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));

        //Create Products

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartphone");
        phone.setImageUrl("https://m.media-amazon.com/images/I/71kduvIxBVL.jpg");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Smart laptop");
        laptop.setDescription("Latest model laptop");
        laptop.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQP9Y1kjQoHDYpu_KtkbwkvoH_whDcyAPV8JA&s");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Smart jacket");
        jacket.setDescription("Latest model jacket");
        jacket.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQANa978finAFaYd-9RMXhS2qk8jkdvJwQSKw&s");
        jacket.setPrice(99.89);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Smart blender");
        blender.setDescription("Latest model blender");
        blender.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpiwXx33PbGfddLcOkEB7en6TG0G1g6U3PQw&s");
        blender.setPrice(199.69);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
    }
}
