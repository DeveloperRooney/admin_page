package com.sh.admin.repository;

import com.sh.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

    Optional<User> findByAccount(String account);
}
