package com.example.crud.service;

import com.example.crud.exception.OutOfStockException;
import com.example.crud.model.Item;
import com.example.crud.repository.ItemRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private Logger log = LoggerFactory.getLogger(ItemService.class);

    public static List<Item> items = new ArrayList<>();

    @Autowired
    private ItemRepository itemRepository;

    static {
        items.add(new Item("soap", 1000, 10.5, "Baby Soap"));
        items.add(new Item("Tooth Brush", 500, 45.5, "Tooth Brush"));
        items.add(new Item("Shirt", 100, 1500.0, "Shirt"));
        items.add(new Item("Office Bag", 400, 10000.0, "Office Bag"));
        items.add(new Item("Bottle", 800, 450.5, "Bottle"));
    }

    public void saveSomeItems(){
        itemRepository.saveAll(items);
    }

    public List<Item> getAllItems() {
        String jsonAllItem = "{}";
        List<Item> allItem = (List<Item>) itemRepository.findAll();

        return allItem;
    }

    public Item getItemById(long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));

        return item;
    }

    public void addItem(Item item) {
        itemRepository.save(item);

    }

    public void updateItemNameAndDescriptionById(long id, Item item) {
        Item itemFromRepository = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Item"));

        itemFromRepository.setDescription(item.getDescription());
        itemFromRepository.setName(item.getName());
        itemRepository.save(itemFromRepository);
    }

    public boolean buyItem(long itemId, int quantity) throws OutOfStockException {
        Item itemFromRepository = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Item"));

        if (itemFromRepository.getStocks() >= quantity) {
            itemFromRepository.setStocks(itemFromRepository.getStocks() - quantity);
            itemRepository.save(itemFromRepository);
            return true;
        } else {
            if (itemFromRepository.getStocks() <= 0) {
                throw new OutOfStockException("Sorry The Item is Current Out Of Stock!");
            }
            throw new OutOfStockException("Sorry The requested Quantity can not be Served Right now!");
        }
    }

    public boolean canQuantityBeServed(long itemId, int quantity) throws OutOfStockException {
        Item itemFromRepository = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Item"));

        if (itemFromRepository.getStocks() >= quantity) {
            return true;
        } else {
            if (itemFromRepository.getStocks() <= 0) {
                throw new OutOfStockException("Sorry The Item is Current Out Of Stock!");
            }
            throw new OutOfStockException("Sorry The requested Quantity can not be Served Right now!");
        }
    }

    public void deleteItem(long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid Item id:" + id));
        itemRepository.delete(item);
    }
}