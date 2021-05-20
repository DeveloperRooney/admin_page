package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {

        AdminUser user = new AdminUser();

        user.setAccount("AdminUser03");
        user.setPassword("AdminUser03");
        user.setStatus("REGISTERED");
        user.setRole("PARTNER");
//        user.setCreatedBy("AdminServer");
//        user.setCreatedAt(LocalDateTime.now());

        AdminUser newAdminUser = adminUserRepository.save(user);
        Assertions.assertNotNull(newAdminUser);

        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);


    }

}
