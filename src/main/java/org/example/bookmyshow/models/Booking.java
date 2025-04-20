package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Booking extends BaseModel {
    @ManyToOne
   // @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> paymentList;
    @ManyToOne
    private Show show;
    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingStatus;
    private Date bookingDate;

}