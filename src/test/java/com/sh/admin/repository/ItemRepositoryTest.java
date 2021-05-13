package com.sh.admin.repository;


import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends AdminApplicationTests {

    @Autowired
    private ItemReposiroty itemReposiroty;

    @Test
    public void create() {

        Item item = new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContents("삼성 노트북");

        Item newItem = itemReposiroty.save(item);

        Assertions.assertNotNull(newItem);


    }

    @Test
    public void read() {

        Optional<Item> item = itemReposiroty.findById(1L);

        Assertions.assertTrue(item.isPresent());

    }
}
