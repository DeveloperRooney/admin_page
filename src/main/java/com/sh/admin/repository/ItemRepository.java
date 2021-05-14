package com.sh.admin.repository;

import com.sh.admin.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ItemRepositoty extends JpaRepository<Item, Long> {
}
