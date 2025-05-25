package com.hotel.Service;

import com.hotel.DTO.MenuDTO;
import com.hotel.Request.HotelRequest;
import com.hotel.Request.MenuRequest;

import java.util.List;

public interface MenuService {


    public MenuDTO addMenu(MenuRequest menuRequest);

    public List<MenuDTO> getAllMenu();

    public List<MenuDTO> getAllMenusByName(String menuName);

    public MenuDTO getAllMenuById(int menuId);

    public MenuDTO updateMenuDetail(int menuId, MenuRequest menuRequest);

    public String deleteMenuDetail(int menuId);
}
