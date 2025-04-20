package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.models.Screen;

@Data
public class ScreenRequestDto {
    private String screenName;
    private String theatreName;
}
