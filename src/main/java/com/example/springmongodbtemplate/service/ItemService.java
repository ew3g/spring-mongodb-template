package com.example.springmongodbtemplate.service;

import com.example.springmongodbtemplate.model.Item;
import com.example.springmongodbtemplate.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
