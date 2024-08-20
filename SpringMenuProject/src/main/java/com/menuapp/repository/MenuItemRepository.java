package com.menuapp.repository;

import com.menuapp.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    Optional<MenuItem> findByDishId(Integer dishId);
    List<MenuItem> findByDishType(String dishType);
}