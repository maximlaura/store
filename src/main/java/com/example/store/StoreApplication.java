package com.example.store;

import com.example.store.repositories.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import com.example.store.domain.Carte;
import com.example.store.repositories.CarteRepository;
import com.example.store.domain.Editura;
import com.example.store.repositories.EdituraRepository;
import com.example.store.user.User;
import com.example.store.user.UserRepository;

@SpringBootApplication
public class StoreApplication {

    private static final Logger log = LoggerFactory.getLogger(StoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);}

/*    @Bean
     public CommandLineRunner bookDemo(CarteRepository repository, EdituraRepository lrepository, UserRepository urepository) {
        return (args) -> {
            log.info("Save a couple of libraries");
            lrepository.save(new Editura("Pasila", "Traian", "Baia Mare", "Maramures", "1234"));
            lrepository.save(new Editura("Haaga", "Pac", "Baia Mare", "Maramures", "1214"));
            lrepository.save(new Editura("Malmi", "Tian", "Baia Mare", "Maramures", "124"));
*/

/*		repository.save(new Book(173323,"Harry Potter","J.K.Rowling", 1998, 20, lrepository.findByLibName("Pasila").get(0)));
		repository.save(new Book(635352,"Alchemist","Paulo Coelho", 1993, 35, lrepository.findByLibName("Pasila").get(0)));*/

            // Create users: admin/admin user/user
           /*User user1 = new User("user", "$2a$10$kDjsYN4dJdIb1takQ1uIFOxXW5.Y2HRmZ1rfYo8PFFCtYUdYm8R1S", "use", "Us", "USER");
            User user2 = new User("admin", "$2a$10$k3NFP84/EomSayQpt2gCgOCwNzekmVtmL24mKwUa2WDpaMqxWUtD.", "ad", "adm", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);

            log.info("Fetch some books");
            for (Carte book : repository.findAll()) {
                log.info(book.toString());
            }
        };}*/
    }

