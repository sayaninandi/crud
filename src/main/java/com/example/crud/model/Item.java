package com.example.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull
    private int stocks;

    private double unitPrice;

    private String description;



    public Item(@NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Number of item in stock is mandatory") int stocks, double unitPrice, String description) {
        this.name = name;
        this.stocks = stocks;
        this.unitPrice = unitPrice;
        this.description = description;
    }

}
