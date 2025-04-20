package org.example.bookmyshow.dtos;

import lombok.Data;

import java.util.List;
@Data
public class BookingTicketRequestDTO {
    private int userId;
    private int showId;
    private List<Integer> seatList;
}
