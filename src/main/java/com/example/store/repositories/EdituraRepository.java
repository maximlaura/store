package com.example.store.repositories;

import com.example.store.domain.Editura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EdituraRepository extends CrudRepository<Editura, Integer> {

    //List<Editura> findByEdiName(String name);
}
