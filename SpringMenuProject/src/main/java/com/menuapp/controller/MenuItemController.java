package com.menuapp.controller;

import com.menuapp.entity.MenuItem;

import com.menuapp.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    
    @GetMapping("/{dishId}")
    public ResponseEntity<MenuItem> getMenuById(@PathVariable("dishId") int dishId) {
        MenuItem menuItem = menuItemService.getMenuById(dishId);
        return new ResponseEntity<>(menuItem, HttpStatus.OK);
    }

    
    @GetMapping("/search/{dishType}")
    public ResponseEntity<List<MenuItem>> getMenusByDishType(@PathVariable("dishType") String dishType) {
        List<MenuItem> menuItems = menuItemService.getMenus(dishType);
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    
    @PostMapping
    public ResponseEntity<MenuItem> addMenu(@RequestBody MenuItem menuItem) {
        MenuItem savedMenuItem = menuItemService.addMenu(menuItem);
        return new ResponseEntity<>(savedMenuItem, HttpStatus.CREATED);
    }
}
