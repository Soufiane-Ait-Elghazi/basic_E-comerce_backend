package org.sid.lightecom;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.sid.lightecom.repositories.CategoryRepository;
import org.sid.lightecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class LightEcomApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LightEcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
        categoryRepository.save(new Category(null,"Computers",null,"computers.png",null));
        categoryRepository.save(new Category(null,"Printers",null,"printers.png",null));
        categoryRepository.save(new Category(null,"Smart phones",null,"smartPhones.png",null));
        Random rn = new Random();
        categoryRepository.findAll().forEach(category -> {
            for(int i = 0 ; i < 10 ; i++) {
                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(100 + rn.nextInt(10000));
                p.setAvailable(rn.nextBoolean());
                p.setSelected(rn.nextBoolean());
                p.setPromotion(rn.nextBoolean());
                p.setCategory(category);
                p.setPhotoName("unknown.png");
                productRepository.save(p);
            }
        });

    }
}
