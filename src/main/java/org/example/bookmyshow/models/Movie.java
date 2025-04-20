package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
public class Movie extends BaseModel{
    @NotNull(message ="Title can not be empty")
    private String title;
    private String description;
    private String genre;
    private int year;
    private int rating;
    private String director;

}
