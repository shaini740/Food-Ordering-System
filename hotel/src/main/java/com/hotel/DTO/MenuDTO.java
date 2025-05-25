package com.hotel.DTO;


import com.hotel.Entity.Hotel;
import lombok.Data;

@Data
public class MenuDTO {

    private int menuId;
    private String menuName;
    private int hotelId;
    private String hotelName;
    private String hotelAddress;

    public MenuDTO() {
    }

    public MenuDTO(int menuId, String menuName, int hotelId, String hotelName, String hotelAddress) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
