package com.example.demo.Repositories;

import com.example.demo.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
