package com.hotel.Service;

import com.hotel.DTO.HotelDTO;
import com.hotel.Entity.Hotel;
import com.hotel.ExceptionHandler.NotFoundException;
import com.hotel.Mapper.Mapper;
import com.hotel.Repository.HotelRepository;
import com.hotel.Request.HotelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public HotelDTO addHotelDetails(HotelRequest hotelRequest) {
       Hotel hotel = mapper.mapToEntityFromHotelRequest(hotelRequest);
       hotel  = hotelRepository.save(hotel);
       HotelDTO hotelDTO = mapper.mapToHotelDtoFromEntity(hotel);
       return hotelDTO;
    }

    @Override
    public HotelDTO getHotelDetailById(int hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(()->
                        new NotFoundException("The Hotel Details is Not Found"));
        HotelDTO hotelDTO = mapper.mapToHotelDtoFromEntity(hotel);
        return hotelDTO;

    }

    @Override
    public List<HotelDTO> getHotelDetailsByName(String hotelName) {
       List<Hotel> hotelDetails = hotelRepository.findAllByHotelNameContainingIgnoreCase(hotelName);
       if(hotelDetails.isEmpty()){
           throw new NotFoundException("Hotel Details Not found for this Name");
       }
       List<HotelDTO> hotelDetailsList = hotelDetails.stream()
               .map(mapper::mapToHotelDtoFromEntity)
               .toList();
       return hotelDetailsList;
    }

    @Override
    public List<HotelDTO> getHotelDetailsByAddress(String hotelAddress) {
        List<Hotel> hotelDetails = hotelRepository.findAllByHotelAddressContainingIgnoreCase(hotelAddress);
        if(hotelDetails.isEmpty()){
            throw new NotFoundException("Hotel Details is Not found for this Address");
        }
        List<HotelDTO> hotelDetailsList = hotelDetails.stream()
                .map(mapper::mapToHotelDtoFromEntity)
                .toList();
        return hotelDetailsList;
    }

    @Override
    public List<HotelDTO> getAllHotelDetails() {

        List<Hotel> hotelDetails = hotelRepository.findAll();
        if(hotelDetails.isEmpty()){
            throw new NotFoundException("No Hotels to Show");
        }
        List<HotelDTO> hotelDetailsList = hotelDetails.stream()
                .map(mapper::mapToHotelDtoFromEntity)
                .toList();
        return hotelDetailsList;
    }

    @Override
    public HotelDTO updateHotelDetailsById(int hotelId,HotelRequest hotelRequest) {
        HotelDTO hotelDetail = getHotelDetailById(hotelId);
        if(hotelRequest.getHotelName() !=null){
            hotelDetail.setHotelName(hotelRequest.getHotelName());
        }
        if(hotelRequest.getHotelAddress() !=null){
            hotelDetail.setHotelAddress(hotelRequest.getHotelAddress());
        }
        Hotel hotel = mapper.mapToEntityFromHotelDTO(hotelDetail);
        hotel = hotelRepository.save(hotel);
        hotelDetail = mapper.mapToHotelDtoFromEntity(hotel);
        return hotelDetail;
    }

    @Override
    public String deleteHotelDetailById(int hotelId) {
        HotelDTO hotelDetails = getHotelDetailById(hotelId);
        hotelRepository.deleteById(hotelId);
        return "Hotel Detail deleted Sucessfully";
    }
}
