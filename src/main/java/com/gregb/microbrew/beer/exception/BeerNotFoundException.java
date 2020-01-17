package com.gregb.microbrew.beer.exception;

public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException(Long id) {
        super("Beer id not found : " + id);
    }

}
