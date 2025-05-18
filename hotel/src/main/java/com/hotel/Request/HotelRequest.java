package com.hotel.Request;

public class HotelRequest {

    private String hotelName;
    private String hotelAddress;

    public HotelRequest() {
    }

    public HotelRequest(String hotelName, String hotelAddress) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
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
