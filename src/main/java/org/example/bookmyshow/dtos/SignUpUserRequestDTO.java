package org.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignUpUserRequestDTO {
    private String username;
    private String password;
    private String email;
}
