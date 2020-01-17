package com.gregb.microbrew.beer.repository;

import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;

import java.util.List;

public interface BeerRepository {

    long addBeer(BeerForm beerForm);

    List<Beer> getBeer();

    Beer findBeer(Long uuid);

    List<Beer> findByName(String name);

    int updateBeer(Beer beer);

    int deleteBeer(Long uuid);

}
