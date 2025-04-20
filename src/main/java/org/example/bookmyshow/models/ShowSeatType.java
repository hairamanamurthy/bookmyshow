package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private double price;
}

//SHOW1 - GOLD 300
//SHOW1 - SILVER 250
//SHOW1 - BRONZE 200

//SHOW2 - GOLD 500
//SHOW2 - SILVER 450
//SHOW3 - BRONZE 400