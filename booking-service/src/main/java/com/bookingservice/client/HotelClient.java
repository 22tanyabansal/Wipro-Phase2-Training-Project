package com.bookingservice.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookingservice.vo.Hotel;

@FeignClient(name = "hotel-service", url = "http://localhost:9004") // You can use the service name or URL
	public interface HotelClient {

	    @GetMapping("/hotels/{hotelId}")
	    Hotel getHotelById(@PathVariable("hotelId") Long hotelId);
	    
	    
	    
	}
