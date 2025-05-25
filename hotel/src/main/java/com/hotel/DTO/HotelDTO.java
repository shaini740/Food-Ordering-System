package com.hotel.DTO;


import com.hotel.Entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO {

    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<MenuDTO> menu;


    //can make use of Lombok annotations to Avoid boiler plate code
    public HotelDTO() {
    }

    public HotelDTO(int hotelId, String hotelName, String hotelAddress, List<MenuDTO> menu) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.menu = menu;
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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public List<MenuDTO> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuDTO> menu) {
        this.menu = menu;
    }
}
