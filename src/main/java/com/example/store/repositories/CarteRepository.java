package com.example.store.repositories;

import com.example.store.domain.Carte;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarteRepository extends CrudRepository<Carte, Integer> {

    //Carte findByTitle(String title);
    //Carte findbyId(Integer id);

}
