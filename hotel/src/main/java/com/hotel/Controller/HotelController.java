package com.hotel.Controller;


import com.hotel.Request.HotelRequest;
import com.hotel.Service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food-order/v1/hotel")
public class HotelController  {


    @Autowired
    private HotelServiceImpl hotelService;


    @PostMapping("/addHotel")
    public ResponseEntity<Object> addHotelDetails(@RequestBody HotelRequest hotelRequest)
    {
        try{
            return new ResponseEntity<>(hotelService.addHotelDetails(hotelRequest), HttpStatus.CREATED);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Something Went Wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<Object> getHotelDetailsById (@PathVariable int hotelId){
            return new ResponseEntity<>(hotelService.getHotelDetailById(hotelId),HttpStatus.OK);
    }

    @GetMapping("/getHotelByName/{hotelName}")
        public ResponseEntity<Object> getHotelDetailsByName(@PathVariable String hotelName){
            return new ResponseEntity<>(hotelService.getHotelDetailsByName(hotelName),HttpStatus.OK);
    }

    @GetMapping("/getHotelByAddress/{hotelAddress}")
    public ResponseEntity<Object> getHotelDetailsByAddress(@PathVariable String hotelAddress){
        return new ResponseEntity<>(hotelService.getHotelDetailsByAddress(hotelAddress),HttpStatus.OK);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<Object> getAllHotelDetails(){
        return new ResponseEntity<>(hotelService.getAllHotelDetails(),HttpStatus.OK);
    }

    @PatchMapping("updateHotel/{hotelId}")
    public ResponseEntity<Object> updateHotelDetails(@PathVariable int hotelId,
                                                     @RequestBody HotelRequest hotelRequest){
        return new ResponseEntity<>(hotelService.updateHotelDetailsById(hotelId,hotelRequest),
                HttpStatus.OK);
    }

    @DeleteMapping("deleteHotel/{hotelId}")
    public ResponseEntity<Object> deleteHotel(@PathVariable int hotelId){
        return new ResponseEntity<>(hotelService.deleteHotelDetailById(hotelId),HttpStatus.OK);
    }
}
