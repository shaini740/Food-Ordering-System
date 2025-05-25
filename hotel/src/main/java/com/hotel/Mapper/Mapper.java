package com.hotel.Mapper;

import com.hotel.DTO.HotelDTO;
import com.hotel.DTO.MenuDTO;
import com.hotel.Entity.Hotel;
import com.hotel.Entity.Menu;
import com.hotel.Request.HotelRequest;
import com.hotel.Request.MenuRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class Mapper {


    public HotelDTO mapToHotelDtoFromEntity(Hotel hotel){

        List<MenuDTO> menuDTOs = hotel.getMenu().stream()
                .map(this::mapToMenuDTO)
                .toList();
        HotelDTO hotelDTO = new HotelDTO(
                hotel.getHotelId(),
                hotel.getHotelName(),
                hotel.getHotelAddress(),
                menuDTOs
        );
        return hotelDTO;
    }

    public Hotel mapToEntityFromHotelDTO(HotelDTO hoteldto){
            List<Menu> menuList = hoteldto.getMenu().stream()
                    .map(this::mapToMenuEntity)
                    .collect(Collectors.toList());

        Hotel hotel = new Hotel(
                hoteldto.getHotelId(),
                hoteldto.getHotelName(),
                hoteldto.getHotelAddress(),
                menuList

        );
        return hotel;
    }

    public Hotel mapToEntityFromHotelRequest(HotelRequest hotelRequest){

        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelRequest.getHotelName());
        hotel.setHotelAddress(hotelRequest.getHotelAddress());
        return hotel;
    }


    public Menu mapToMenuEntity(MenuDTO menuDTO){
        Hotel hotel = new Hotel();
        hotel.setHotelId(menuDTO.getHotelId());
        hotel.setHotelName(menuDTO.getHotelName());
        hotel.setHotelAddress(menuDTO.getHotelAddress());
        Menu menu = new Menu(
                menuDTO.getMenuId(),
                menuDTO.getMenuName(),
                hotel
        );
        return menu;
    }

    public MenuDTO mapToMenuDTO(Menu menu)
    {
        MenuDTO  menuDTO = new MenuDTO(
                menu.getMenuId(),
                menu.getMenuName(),
                menu.getHotel().getHotelId(),
                menu.getHotel().getHotelName(),
                menu.getHotel().getHotelAddress()
        );
        return menuDTO;
    }

    public Menu mapRequestToMenuEntity(MenuRequest menuRequest){
        Menu menu  = new Menu();
        menu.setMenuName(menuRequest.getMenuName());

        return menu;
    }

}
