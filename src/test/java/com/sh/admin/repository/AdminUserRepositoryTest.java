package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {

        AdminUser user = new AdminUser();

        user.setAccount("han_0427");
        user.setPassword("suhan1994");
        user.setStatus("REGISTERED");
        user.setRole("PARTNER");
        user.setCreatedBy("AdminServer");
        user.setCreatedAt(LocalDateTime.now());

        adminUserRepository.save(user);


    }

}
