package com.example.store;

import com.example.store.user.User;
import com.example.store.user.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTest {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user =new User();
        user.setUsername("pavelist");
        user.setPassword("pave.");
        user.setFirstName("Pavel");
        user.setLastName("Pop");
        User savedUser = repo.save(user);
        assertThat(savedUser, Matchers.notNullValue());
        assertThat(savedUser.getId(), Matchers.greaterThan(0));
    }

    @Test
    public void testListAll(){
        Iterable<User> users=repo.findAll();
int counter=0;
        for(User user:users){
            counter++;
        }
        assertThat(counter, Matchers.greaterThan(0));
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User> optionalUser = repo.findById(userId);
        User user =optionalUser.get();

        user.setPassword("hello");
        repo.save(user);

        User updatedUser=repo.findById(userId).get();
        assertThat(updatedUser.getPassword(), equalTo("hello"));
    }

    @Test

    public void testGet(){
        Integer userId=2;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertTrue(optionalUser.isPresent());
        System.out.println(optionalUser.get());
    }

   /* @Test

    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        assertThat(optionalUser, is(not(optionalUser.isPresent())));
        //Assertions.assertTrue(optionalUser.isNotPresent());
    }*/
}
