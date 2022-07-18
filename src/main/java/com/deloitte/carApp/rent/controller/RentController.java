package com.deloitte.carApp.rent.controller;

import com.deloitte.carApp.rent.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rents")
@AllArgsConstructor
public class RentController {

    private RentService rentService;


}
