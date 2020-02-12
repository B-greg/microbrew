package com.gregb.microbrew.beer.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
@Data
public class Beer {

    @Getter @Setter @NonNull
    private Long id;

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter
    private  String brand;

    @Getter @Setter @NonNull
    private Date createdAt;

    @Getter @Setter @NonNull
    private Date updatedAt;

    public Beer() {
    }

    public Beer(@NonNull Long id, @NonNull String name, String brand, @NonNull Date createdAt, @NonNull Date updatedAt) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
