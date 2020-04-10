package com.example.crud.controller;


import com.example.crud.model.Item;
import com.example.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.crud.util.Util.toJson;

@RestController
@RequestMapping("/item")
public class ItemCrudController {

    @Autowired
    private ItemService itemService;


    @GetMapping(value = "/list")
    public String getAllItems() {

        List<Item> allItems = itemService.getAllItems();
        return toJson(allItems);
    }


    @GetMapping("/{id}")
    public String getItemById(@PathVariable("id") long id) {

        Item item = itemService.getItemById(id);
        return toJson(item);
    }

    @PostMapping(value = "/add")
    public String addItem(@RequestBody Item item) {
        itemService.addItem(item);
        return "Item Added Successfully !";
    }

    @PutMapping("/update/{id}")
    public String updateItemNameAndDescriptionById(@PathVariable("id") long id, @RequestBody Item item) {
        itemService.updateItemNameAndDescriptionById(id, item);
        return "Item Updated Successfully !";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") long id) {
        itemService.deleteItem(id);
        return "Item with given Id is deleted Successfully !";
    }
}
