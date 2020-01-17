package com.gregb.microbrew.beer.controller;

import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;
import com.gregb.microbrew.beer.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/beers/admin")
public class BeerViewController {

    @Autowired
    BeerService beerService;

    @GetMapping(value={"/", ""})
    String adminBeers(Model model) {
        List<Beer> beers = beerService.getAll();
        model.addAttribute("beers", beers);
        return "beers";
    }

    @GetMapping("/{id}")
    String adminBeer(@PathVariable("id") Long id, Model model) {
        Beer beer = beerService.find(id);
        model.addAttribute("beer", beer);
        return "beer";
    }

    @GetMapping("/create")
    public String beerForm(Model model) {
        model.addAttribute("beerForm", new BeerForm());
        return "beer_create";
    }

    @PostMapping("/create")
    public String beerSubmit(@ModelAttribute BeerForm beerForm) {
        long id = beerService.create(beerForm);
        return "redirect:/beers/admin/" + id;
    }
}
