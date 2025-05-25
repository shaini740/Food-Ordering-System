package com.hotel.Request;

public class MenuRequest {

    private String menuName;
    private Integer hotelId;


    public MenuRequest() {
    }

    public MenuRequest(String menuName, int hotelId) {
        this.menuName = menuName;
        this.hotelId = hotelId;
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
}
