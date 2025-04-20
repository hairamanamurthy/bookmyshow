package org.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignUpUserResponseDTO {
    private String message;
    private ResponseStatus status;
    private int userId;
}
