package org.example.bookmyshow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name= "shows")
public class Show extends BaseModel{
    private String title;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Screen screen;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ShowSeatType> showSeatTypes;
    private Date showTime;


}
