package org.example.bookmyshow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Screen extends BaseModel{
    private String name;
    @ManyToOne
    private Theatre theatre;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats; //Do we need to maintain seat object or seat capacity here ?
}
