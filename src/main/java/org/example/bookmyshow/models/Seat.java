package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {
    private String seatName;
    private int rowNum;
    private int columnNum;
    @ManyToOne
    private SeatType seatType;
}
