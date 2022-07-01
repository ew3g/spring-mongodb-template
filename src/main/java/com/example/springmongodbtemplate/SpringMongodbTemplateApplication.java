package com.example.springmongodbtemplate;

import com.example.springmongodbtemplate.model.Item;
import com.example.springmongodbtemplate.repository.ItemRepository;
import com.example.springmongodbtemplate.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongodbTemplateApplication implements CommandLineRunner {

	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbTemplateApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var item = new Item();
		item.setName("myitem");
		//itemRepository.deleteAll();
		//itemRepository.save(item);
	}

	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}
