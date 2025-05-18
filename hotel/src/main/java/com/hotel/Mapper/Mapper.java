package com.hotel.Mapper;

import com.hotel.DTO.HotelDTO;
import com.hotel.Entity.Hotel;
import com.hotel.Request.HotelRequest;
import org.springframework.stereotype.Component;


@Component
public class Mapper {


    public HotelDTO mapToHotelDtoFromEntity(Hotel hotel){

        HotelDTO hotelDTO = new HotelDTO(
                hotel.getHotelId(),
                hotel.getHotelName(),
                hotel.getHotelAddress()
        );
        return hotelDTO;
    }

    public Hotel mapToEntityFromHotelDTO(HotelDTO hoteldto){

        Hotel hotel = new Hotel(
                hoteldto.getHotelId(),
                hoteldto.getHotelName(),
                hoteldto.getHotelAddress()
        );
        return hotel;
    }

    public Hotel mapToEntityFromHotelRequest(HotelRequest hotelRequest){

        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelRequest.getHotelName());
        hotel.setHotelAddress(hotelRequest.getHotelAddress());

        return hotel;
    }




}
