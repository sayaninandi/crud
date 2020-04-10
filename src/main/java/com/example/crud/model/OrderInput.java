package com.example.crud.model;

import com.example.crud.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInput {

    private Customer customer;
    private ItemOrdered itemOrdered;
    private List<ItemOrdered> listOfItem;
    private String type;
}
