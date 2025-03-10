package com.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.bookingservice.client.HotelClient;
import com.bookingservice.entity.Booking;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.vo.Hotel;
import com.bookingservice.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {
	
	private static final String HOTEL_SERVICE = "hotelService";
	
	@Autowired
	private BookingRepository bookingRepository;
	
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 @Autowired
	 private HotelClient hotelClient;
	
	public Booking saveBooking(Booking Booking) {
		log.info("Inside saveBooking of BookingService");
		return bookingRepository.save(Booking);
	}
	
	@CircuitBreaker(name = HOTEL_SERVICE, fallbackMethod = "hotelServiceFallback")
    public ResponseTemplateVO getBookingWithHotel(Long bookingId) {
        log.info("Inside getBookingWithHotel of BookingService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Booking booking = bookingRepository.findByBookingId(bookingId);
 
        Hotel hotel = hotelClient.getHotelById(booking.getHotelId());
        vo.setBooking(booking);
        vo.setHotel(hotel);
        return vo;
    }
 
    // Fallback method for Circuit Breaker
    public ResponseTemplateVO hotelServiceFallback(Long bookingId, Exception e) {
        log.error("Hotel Service is down, returning fallback response.", e);
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Booking booking = bookingRepository.findByBookingId(bookingId);
 
        Hotel fallbackHotel = new Hotel(0L, "No Hotel", "No Location", "No Amenities");
 
        vo.setBooking(booking);
        vo.setHotel(fallbackHotel);
 
        return vo;
    }
}
