package com.sh.admin.repository;

import com.sh.admin.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByName(String name);
}
