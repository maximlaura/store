package com.example.store.user;

import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository <User, Integer>{

    User findByUsername(String username);
}
