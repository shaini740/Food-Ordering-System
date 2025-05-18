package com.hotel.Repository;

import com.hotel.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    public List<Hotel> findAllByHotelNameContainingIgnoreCase(String hotelName);
    public List<Hotel> findAllByHotelAddressContainingIgnoreCase(String hotelAddress);
}
