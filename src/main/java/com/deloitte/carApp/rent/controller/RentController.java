package com.deloitte.carApp.rent.controller;

import com.deloitte.carApp.rent.dto.CreateRentDto;
import com.deloitte.carApp.rent.dto.RentDto;
import com.deloitte.carApp.rent.entity.Rent;
import com.deloitte.carApp.rent.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rents/")
@AllArgsConstructor
public class RentController {

    private RentService rentService;

    @GetMapping("all")
    public ResponseEntity<List<RentDto>> getAllRents() {
        return ResponseEntity.ok(rentService.findAllRents());
    }

    @GetMapping("rent-id/{rentId}")
    public ResponseEntity<RentDto> getRent(@PathVariable("rentId") Long rentId) {
        return ResponseEntity.ok(rentService.getRentDto(rentId));
    }

    @PostMapping("add-rent")
    public ResponseEntity<Rent> addRent(@RequestBody CreateRentDto createRentDto) {
        return ResponseEntity.ok(rentService.saveRent(createRentDto));
    }
}
