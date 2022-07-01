package com.example.springmongodbtemplate;

import com.example.springmongodbtemplate.controller.ItemController;
import com.example.springmongodbtemplate.model.Item;
import com.example.springmongodbtemplate.repository.ItemRepository;
import com.example.springmongodbtemplate.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class ItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    ItemRepository itemRepository;


    @BeforeEach
    public void setUp() {
        var itemService = new ItemService();
        itemService.setItemRepository(itemRepository);

        var itemController = new ItemController();
        itemController.setItemService(itemService);

        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }


    @Test
    public void test() throws Exception {
        Mockito.when(itemRepository.findAll()).thenReturn(List.of(new Item(), new Item()));
        var result = this.mockMvc.perform(get("/v1/item")).andExpect(status().isOk()).andReturn();
        Assertions.assertNotNull(result.getResponse().getContentAsString());
    }

    //https://www.baeldung.com/integration-testing-in-spring
}
