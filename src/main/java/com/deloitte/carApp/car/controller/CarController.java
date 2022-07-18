package com.deloitte.carApp.car.controller;

import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.car.dto.CreateCarDto;
import com.deloitte.carApp.car.dto.GetCarDto;
import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    private WorkerService workerService;

    @GetMapping("")
    public ResponseEntity<List<GetCarDto>> getAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @PutMapping("/assign-car/carId/{carId}/workerId/{workerId}")
    public ResponseEntity<Car> assignCar(@PathVariable("carId") Long carId,
                                         @PathVariable("workerId") Long workerId) {
        return ResponseEntity.accepted()
                .body(carService.assignWorkerToCar(
                        carService.findCar(carId), workerService.findWorker(workerId)));
    }

    @PutMapping("/carType/{carType}/brand/{brand}")
    public ResponseEntity<GetCarDto> getCarByCarTypeAndBrand(@PathVariable("carType") String carType,
                                                             @PathVariable("brand") String brand) {
        return ResponseEntity.ok(carService.findCarByCarTypeAndBrand(carType, brand));
    }

    @PostMapping("add-car")
    public ResponseEntity<Car> addCar(@RequestBody CreateCarDto createCarDto) {
        return ResponseEntity.ok(carService.saveCar(createCarDto));
    }

    @DeleteMapping("delete-car/carId/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return ResponseEntity.ok().build();
    }
}
