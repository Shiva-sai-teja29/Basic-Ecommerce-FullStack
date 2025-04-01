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
//        categoryRepository.deleteAll();
//        productRepository.deleteAll();


        //Create Categories
        Category electronics = new Category();
        electronics.setName("Food");

        Category clothing = new Category();
        clothing.setName("Furniture");

        Category home = new Category();
        home.setName("Jewellery");

        categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));

        //Create Products

        Product phone = new Product();
        phone.setName("Ice-cream");
        phone.setDescription("Chocolate delicious Flavour");
        phone.setImageUrl("https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2022-08/ice-cream-chocolate-bo-220810-94f45d.jpg");
        phone.setPrice(2.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Freezed Parrota");
        laptop.setDescription("Parota - heat 2min to eat");
        laptop.setImageUrl("https://5.imimg.com/data5/ANDROID/Default/2023/6/313353442/GJ/EV/DR/53595356/product-jpeg.jpg");
        laptop.setPrice(9.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Smart Sofa");
        jacket.setDescription("Flexible Sofa");
        jacket.setImageUrl("https://m.media-amazon.com/images/I/31m6AxwTXVL.jpg");
        jacket.setPrice(99.89);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Necklace");
        blender.setDescription("Platinum Simple Necklace");
        blender.setImageUrl("https://www.mannash.in/cdn/shop/products/MZSND292D564_M.jpg?v=1643980580");
        blender.setPrice(199.69);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
    }
}
