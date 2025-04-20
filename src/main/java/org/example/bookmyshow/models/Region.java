package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Region extends BaseModel {
    private String name;


}
