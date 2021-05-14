package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    @Test
    public void create() {

        OrderDetail od = new OrderDetail();
        
        od.setOrderAt(LocalDateTime.now());
        
//         상품 인덱스
//        od.setItem(1L);

//         유저 인덱스
//        od.setUser();

        OrderDetail newOd = orderDetailRepository.save(od);

        Assertions.assertNotNull(newOd);
        
        
    }
}
