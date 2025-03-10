package com.bookingservice.vo;

import com.bookingservice.entity.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Booking booking;
    private Hotel hotel;
}
