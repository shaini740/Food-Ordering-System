package com.hotel.Service;

import com.hotel.DTO.HotelDTO;
import com.hotel.Request.HotelRequest;

import java.util.List;

public interface HotelService {

    public HotelDTO addHotelDetails(HotelRequest hotelRequest);

    public HotelDTO getHotelDetailById(int hotelId);

    public List<HotelDTO> getHotelDetailsByName (String hotelName);

    public List<HotelDTO> getHotelDetailsByAddress(String hotelAddress);

    public List<HotelDTO> getAllHotelDetails();

    public HotelDTO updateHotelDetailsById(int hotelId,HotelRequest hotelRequest);

    public String deleteHotelDetailById(int hotelId);
}
