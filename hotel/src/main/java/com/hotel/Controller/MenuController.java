package com.hotel.Controller;


import com.hotel.Request.MenuRequest;
import com.hotel.Service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food-order/v1/menu")
public class MenuController {


    @Autowired
    private MenuServiceImpl menuService;


    @PostMapping
    public ResponseEntity<Object> addMenu(@RequestBody MenuRequest menuRequest){
        return new ResponseEntity<>(menuService.addMenu(menuRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllMenu(){
        return new ResponseEntity<>(menuService.getAllMenu(),HttpStatus.OK);
    }

    @GetMapping("/menuName/{menuName}")
    public ResponseEntity<Object> getMenusByName(@PathVariable String menuName){
        return new ResponseEntity<>(menuService.getAllMenusByName(menuName),HttpStatus.OK);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<Object> getMenuByMenuId(@PathVariable int menuId){
        return new ResponseEntity<>(menuService.getAllMenuById(menuId),HttpStatus.OK);
    }

    @PatchMapping("/{menuId}")
    public ResponseEntity<Object> updateMenuByMenuId(@PathVariable int menuId,
                                                     @RequestBody MenuRequest menuRequest){
        return new ResponseEntity<>(menuService.updateMenuDetail(menuId,menuRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Object> deleteMenuByMenuId(@PathVariable int menuId){
        return new ResponseEntity<>(menuService.deleteMenuDetail(menuId),HttpStatus.OK);
    }

}
