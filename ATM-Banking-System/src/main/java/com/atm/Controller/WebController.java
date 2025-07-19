package com.atm.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
public class WebController {

    @GetMapping
    public String hello(){
        return  "ATM IS Working";
    }
}
