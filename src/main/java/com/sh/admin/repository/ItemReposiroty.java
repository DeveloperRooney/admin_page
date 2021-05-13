package com.sh.admin.repository;

import com.sh.admin.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemReposiroty extends JpaRepository<Item, Long> {
}
