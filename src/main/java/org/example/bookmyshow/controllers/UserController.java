package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.dtos.SignUpUserRequestDTO;
import org.example.bookmyshow.dtos.SignUpUserResponseDTO;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpUserResponseDTO signUpUser(SignUpUserRequestDTO request) {
        SignUpUserResponseDTO response = new SignUpUserResponseDTO();
        try{
            User user=userService.signUpUSer(request.getUsername(),request.getEmail(),request.getPassword());
            response.setUserId(user.getId());
            response.setMessage("Sign up successful");
            response.setStatus(ResponseStatus.SUCCESS);
        }catch(Exception ex){
            response.setMessage("User creation failed"+ ex.getMessage());
            response.setStatus(ResponseStatus.FAILURE);

        }
        return response;
    }

}
