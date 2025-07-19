package com.atm.Controller;

import com.atm.Model.User;
import com.atm.Request.LoginRequest;
import com.atm.response.JwtResponse;
import com.atm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
//        System.out.println("==================================="+user.getPin());
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
}
