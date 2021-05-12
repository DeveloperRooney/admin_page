package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("안대근");
        user.setEmail("suhan0218@naver.com");
        user.setPhone("010-4063-0056");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        userRepository.save(user);
    }

    @Test
    public void read() {

        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
        });
    }

    public void update() {

    }

    @Test
    public void delete() {
        User user = new User();
        user.setAccount("KIMSUHAN");
        userRepository.delete(user);

    }

}
