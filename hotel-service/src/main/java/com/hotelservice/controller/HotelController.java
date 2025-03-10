package com.hotelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hotels")
@Slf4j
public class HotelController {
	@Autowired
	private HotelService hotelService;

	@PostMapping("/")
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		log.info("Inside saveHotel method of HotelController");
		return hotelService.saveHotel(hotel);
	}

	@GetMapping("/{id}")
	public Hotel findHotelById(@PathVariable("id") Long hotelId) {
		log.info("Inside findHotelById method of HotelController");
		return hotelService.findHotelById(hotelId);
	}
}
