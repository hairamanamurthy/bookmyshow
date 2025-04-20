package org.example.bookmyshow.services;

import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signUpUSer(String username, String email, String password){
        //check whether user already exits in DB based on email
        Optional<User> userOptional=userRepository.findByEmail(email);
        if(userOptional.isPresent()){
           throw new RuntimeException("User already exists");
        }
        User user=new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
