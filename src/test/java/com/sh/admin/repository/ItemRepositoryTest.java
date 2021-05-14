package com.sh.admin.repository;


import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends AdminApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {

        Item item = new Item();
        item.setStatus("REGISTERED");
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");
        item.setTitle("SAMSUNG NOTEBOOK");
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("AdminServer");
        item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);

        Assertions.assertNotNull(newItem);


    }

    @Test
    public void read() {

        Optional<Item> item = itemRepository.findById(1L);

        Assertions.assertTrue(item.isPresent());

    }
}
