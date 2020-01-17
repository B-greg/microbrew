package com.gregb.microbrew.beer.service;

import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;

import java.util.List;

public interface BeerService {

    List<Beer> getAll();

    Beer find(Long id);

    List<Beer> findByName(String name);

    long create(BeerForm beerForm);

    int update(Beer beer);

    int delete(Long id);

}
