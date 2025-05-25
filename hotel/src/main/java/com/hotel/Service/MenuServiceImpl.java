package com.hotel.Service;


import com.hotel.DTO.MenuDTO;
import com.hotel.Entity.Hotel;
import com.hotel.Entity.Menu;
import com.hotel.ExceptionHandler.NotFoundException;
import com.hotel.Mapper.Mapper;
import com.hotel.Repository.HotelRepository;
import com.hotel.Repository.MenuRepository;
import com.hotel.Request.MenuRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public MenuDTO addMenu(MenuRequest menuRequest) {
        Hotel hotel  = hotelRepository.findById(menuRequest.getHotelId()).orElseThrow(
                ()-> new NotFoundException("The Hotel with Hotel Id "+menuRequest.getHotelId()+" is not Found")
        );
        Menu menu = mapper.mapRequestToMenuEntity(menuRequest);
        menu.setHotel(hotel);
        menu = menuRepository.save(menu);
        MenuDTO menuDTO = mapper.mapToMenuDTO(menu);
        return menuDTO;
    }

    @Override
    public List<MenuDTO> getAllMenu() {
       List<Menu> menu = menuRepository.findAll();
       List<MenuDTO> menuList = menu.stream()
               .map(mapper::mapToMenuDTO)
               .toList();
       return menuList;
    }

    @Override
    public List<MenuDTO> getAllMenusByName(String menuName) {
       List<Menu> menu = menuRepository.findByMenuNameContainingIgnoreCase(menuName);
       if (menu.isEmpty()){
           throw new NotFoundException("The Menu is Not Found");
       }
       else{
           List<MenuDTO> menuDTOS = menu.stream()
                   .map(mapper::mapToMenuDTO)
                   .toList();
           return menuDTOS;
       }
    }

    @Override
    public MenuDTO getAllMenuById(int menuId) {
       Menu menu = menuRepository.findById(menuId).orElseThrow(
               () -> new NotFoundException("Menu with Menu Id "+menuId+" is Not Found")
       );
       MenuDTO menuDTO = mapper.mapToMenuDTO(menu);
       return menuDTO;
    }

    @Override
    public MenuDTO updateMenuDetail(int menuId, MenuRequest menuRequest) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                ()-> new NotFoundException("Menu with Menu ID "+menuId+" is Not Found")
        );

        if(menuRequest.getMenuName()!=null){
            menu.setMenuName(menuRequest.getMenuName());
        }
        Integer hotelId = menuRequest.getHotelId();
        if(hotelId != null){
            Hotel hotelDetails = hotelRepository.findById(menuRequest.getHotelId())
                    .orElseThrow(()-> new NotFoundException("Hotel with Hotel ID "+menuRequest.getHotelId()+
                            " is not found"));
            menu.setHotel(hotelDetails);
        }
        menu = menuRepository.save(menu);
        MenuDTO menuDetails = mapper.mapToMenuDTO(menu);
        return menuDetails;
    }

    @Override
    public String deleteMenuDetail(int menuId) {
       Menu menu  = menuRepository.findById(menuId).orElseThrow(
               ()-> new NotFoundException("The Menu with Menu Id "+menuId+" is Not Found")
       );
       menuRepository.deleteById(menuId);
       return "The Menu details is Deleted Successfully";
    }
}
