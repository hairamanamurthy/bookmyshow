package org.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class ShowRequestDto {
    private String title;
    private int movieId;
    private int theatreId;
    private int screenId;
    private String showTime;
}
