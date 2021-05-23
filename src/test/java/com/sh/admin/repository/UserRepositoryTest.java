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
    @Transactional
    public void create() {

        String account = "Test04";
        String password = "Test04";
        String status = "REGISTERED";
        String email = "Test04@naver.com";
        String phoneNumber = "010-1111-4444";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();

        user.setAccount(account);
        user.setStatus(status);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user.setEmail(email);
        user.setRegisteredAt(registeredAt);

        User u = User.builder().
                account(account).
                password(password).
                status(status).
                email(email).
                build();

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void readUser() {

        Optional<User> user = userRepository.findByAccount("suhan0218");

        System.out.println(user.get().getEmail());
    }


    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("01000000000");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("----- 주문 묶음 -----");
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("총수량 : " + orderGroup.getTotalQuantity());
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("수령인 : " + orderGroup.getRevName());


            System.out.println("----- 주문 상세 -----");
            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문 상태 : " + orderDetail.getStatus());
                System.out.println("도착 예정 일자 : " + orderDetail.getArrivalDate());
            });
        });

        Assertions.assertNotNull(user);

    }

    @Test
    public void update() {


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
