package com.hotelservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelservice.entity.Hotel;
import com.hotelservice.repository.HotelRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel saveHotel(Hotel hotel) {
		log.info("Inside saveHotel of HotelService");
		return hotelRepository.save(hotel);
	}

	public Hotel findHotelById(Long hotelId) {
		log.info("Inside saveHotel of HotelService");
		return hotelRepository.findByHotelId(hotelId);
	}
}
