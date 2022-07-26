package com.deloitte.carApp.car.controller;

import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.car.dto.CarDto;
import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.helpers.combinedservices.WorkerCarService;
import com.deloitte.carApp.worker.entity.Worker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars/")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    private WorkerCarService workerCarService;

    @GetMapping("all")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    /*
        How to specify url for such names?
     */
    @GetMapping("rented-more-than-10-times")
    public ResponseEntity<List<CarDto>> findCarsRentedMoreThan10Times() {
        return ResponseEntity.ok(carService.findCarsRentedMoreThan10Times());
    }

    @GetMapping("car-id/{carId}")
    public ResponseEntity<Car> getAllCars(@PathVariable("carId") Long carId) {
        return ResponseEntity.ok(carService.findCar(carId));
    }

    @GetMapping("worker-id/{workerId}")
    public ResponseEntity<List<CarDto>> getCarsByWorker(@PathVariable("workerId") Long workerId) {
        return ResponseEntity.ok(workerCarService.findCarsByWorker(workerId));
    }

    @GetMapping("car-type/{carType}/brand/{brand}")
    public ResponseEntity<CarDto> getCarByCarTypeAndBrand(@PathVariable("carType") String carType,
                                                          @PathVariable("brand") String brand) {
        System.out.println("cos");
        return ResponseEntity.ok(carService.findCarByCarTypeAndBrand(carType, brand));
    }

    @PutMapping("update-car/car-id/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable("carId") Long carId,
                                         @RequestBody CarDto carDto) {
        return ResponseEntity.accepted().body(carService.updateCar(carId, carDto));
    }

    @PostMapping("assign-car/car-id/{carId}/worker-id/{workerId}")
    public ResponseEntity<Worker> assignCarToWorker(@PathVariable("carId") Long carId,
                                                    @PathVariable("workerId") Long workerId) {
        return ResponseEntity.ok(workerCarService.assignWorkerToCar(carId, workerId));
    }

    @PostMapping("add-car")
    public ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.saveCar(carDto));
    }

    @DeleteMapping("delete-car/car-id/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return ResponseEntity.ok().build();
    }
}
