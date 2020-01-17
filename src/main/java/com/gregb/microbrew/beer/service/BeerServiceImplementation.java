package com.gregb.microbrew.beer.service;

import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;
import com.gregb.microbrew.beer.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerServiceImplementation  implements  BeerService {

    @Autowired
    BeerRepository beerRepository;

    @Override
    public List<Beer> getAll() {
        return beerRepository.getBeer();
    }

    @Override
    public Beer find(Long id) {
        return beerRepository.findBeer(id);
    }

    @Override
    public List<Beer> findByName(String name) {
        return beerRepository.findByName(name);
    }

    @Override
    public long create(BeerForm beerForm) {
        return beerRepository.addBeer(beerForm);
    }

    @Override
    public int update(Beer beer) {
        return beerRepository.updateBeer(beer);
    }

    @Override
    public int delete(Long id) {
        return beerRepository.deleteBeer(id);
    }
}
