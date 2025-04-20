package org.example.bookmyshow;

import org.example.bookmyshow.controllers.UserController;
import org.example.bookmyshow.dtos.SignUpUserRequestDTO;
import org.example.bookmyshow.dtos.SignUpUserResponseDTO;
import org.example.bookmyshow.models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {
        "org.example.bookmyshow.controllers",
        "org.example.bookmyshow.services",
        "org.example.bookmyshow.repos",
        "org.example.bookmyshow.models",
        "org.example.bookmyshow.dtos"
})
//public class BookMyShowApplication implements CommandLineRunner {
public class BookMyShowApplication {

//    @Autowired
//    private UserController userController;
//    @Override
//    public void run(String... args) throws Exception {
//        SignUpUserRequestDTO request = new SignUpUserRequestDTO();
//        request.setEmail("hairamanamurthy1@gmail.com");
//        request.setPassword("password");
//        request.setUsername("hairamanamurthy");
//        SignUpUserResponseDTO response=userController.signUpUser(request);
//        System.out.println(response.getMessage());
//    }

    public static void main(String[] args) {



        SpringApplication.run(BookMyShowApplication.class, args);
    }


}
