package com.gregb.microbrew.beer.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
public class BeerForm {

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter
    private  String brand;

    public BeerForm(@NonNull String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public BeerForm() {
    }
}
