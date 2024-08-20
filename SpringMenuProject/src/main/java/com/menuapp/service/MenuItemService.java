package com.menuapp.service;

import com.menuapp.entity.MenuItem;
import com.menuapp.exception.MenuException;

import com.menuapp.repository.MenuItemRepository;

import jakarta.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    // Method to add a new menu item
    public MenuItem addMenu(MenuItem menuItem) throws ValidationException {
        // Add any validation logic here if needed
        return menuItemRepository.save(menuItem); // Use the inherited save method
    }

    // Method to get all dishes based on dishType
    public List<MenuItem> getMenus(String dishType) {
        return menuItemRepository.findByDishType(dishType);
    }

    // Method to get a dish by its ID
    public MenuItem getMenuById(int id) throws MenuException {
        return menuItemRepository.findByDishId(id)
                .orElseThrow(() -> new MenuException("Dish not found"));
    }
}