package com.example.springmongodbtemplate.repository;

import com.example.springmongodbtemplate.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    public List<Item> findAll();
}
