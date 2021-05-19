package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    @Test
    public void create() {

        OrderDetail od = new OrderDetail();
        
        od.setStatus("WAITING");
        od.setArrivalDate(LocalDateTime.now().plusDays(2));
        od.setQuantity(1);
        od.setTotalPrice(BigDecimal.valueOf(900000));
//        od.setOrderGroupId(1L);
        od.setItemId(1L);
        od.setCreatedAt(LocalDateTime.now());
        od.setCreatedBy("AdminServer");

        OrderDetail newOd = orderDetailRepository.save(od);

        Assertions.assertNotNull(newOd);
        
        
    }
}
