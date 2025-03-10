package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.entity.Booking;
import com.bookingservice.service.BookingService;
import com.bookingservice.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping("/")
	public Booking createBooking(@RequestBody Booking booking) {
		log.info("Inside saveBooking method of BookingController");
		return bookingService.saveBooking(booking);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getBookingById(@PathVariable("id") Long bookingId) {
		log.info("Inside findBookingById method of BookingController");
		return bookingService.getBookingWithHotel(bookingId);
	}
}
