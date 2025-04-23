package org.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class ShowSeatTypeDto {
    private int showId;
    private int seatTypeId;
    private double price;

}
