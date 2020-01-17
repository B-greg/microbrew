package com.gregb.microbrew.beer.controller;

import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;
import com.gregb.microbrew.beer.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerController {

    @Autowired
    BeerService beerService;

    @GetMapping(value={"/", ""})
    List<Beer> allBeer() {
        return beerService.getAll();
    }

    @PostMapping(value={"/", ""})
    long saveBeer(@RequestBody BeerForm beerForm) {
        return beerService.create(beerForm);
    }

    @PostMapping("/{id}")
    int updateBeer(@RequestBody Beer beer) {
        return beerService.update(beer);
    }

    @GetMapping("/{id}")
    Beer findById(@PathVariable("id") Long id){
        return  beerService.find(id);
    }

    @GetMapping("/find")
    List<Beer> findByName(@RequestParam("name") String name){
        return beerService.findByName(name);
    }

    @DeleteMapping("/{id}")
    int delete(@PathVariable("id") Long id){
        return beerService.delete(id);
    }

}
