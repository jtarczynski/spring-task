package com.deloitte.carApp.controller;

import com.deloitte.carApp.dto.CreateCarDto;
import com.deloitte.carApp.dto.GetCarDto;
import com.deloitte.carApp.service.CarService;
import com.deloitte.carApp.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    private WorkerService workerService;

    @GetMapping("all-cars")
    public ResponseEntity<List<GetCarDto>> getAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @PutMapping("assign-car/carId/{carId}/workerId/{workerId}")
    public ResponseEntity<Void> addCar(@PathVariable Long carId,
                                       @PathVariable Long workerId) {
        carService.assignWorkerToCar(carService.findCarById(carId), workerService.findWorkerById(workerId));
        return ResponseEntity.accepted().build();
    }

    @PostMapping("add-car")
    public ResponseEntity<Void> addCar(@RequestBody CreateCarDto createCarDto) {
        carService.saveCar(createCarDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete-car/carId/{carId}")
    public ResponseEntity<Void> addCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return ResponseEntity.ok().build();
    }
}
