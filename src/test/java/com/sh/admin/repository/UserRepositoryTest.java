package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.Item;
import com.sh.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("김수한");
        user.setEmail("suhan0218@naver.com");
//        user.setPhone("010-4063-0056");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        userRepository.save(user);
    }

    @Test
    @Transactional
    public void read() {

        // select * from user where id = ?
        Optional<User> user = userRepository.findByAccount("김수한");
//        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> {

            selectUser.getOrderDetailList().stream().forEach((detail-> {

//                Item item = detail.getItem();
//                System.out.println(item);
            }));
        });

//        user.ifPresent(selectUser -> {
//            System.out.println(selectUser);
//        });

    }

    @Test
    public void update() {

        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser-> {
            selectUser.setAccount("업데이트 테스트");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
        
    }

    @Test
    @Transactional
    public void delete() {
        
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
        
        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent());

    }

}
