package org.example.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    private Movie movie;
    @ManyToOne
    @JsonIgnore
    private Theatre theatre;
    @ManyToOne
    @JsonIgnore
    private Screen screen;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference // Serialize the ShowSeat list properly
    private List<ShowSeat> showSeats;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference // Serialize the ShowSeat list properly
    private List<ShowSeatType> showSeatTypes;
    private Date showTime;


}
