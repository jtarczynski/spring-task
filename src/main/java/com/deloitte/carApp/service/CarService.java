package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    public Car findCarById(Long id) {
        return carRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public Car findCarByTypeAndBrand(String type, String brand) {
        return carRepository
                .findByCarTypeAndBrand(type, brand)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public void saveCarById(Long id) {
        carRepository.save(findCarById(id));
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public void assignWorkerToCar(Long id, Worker worker) {
        Car car = findCarById(id);
        car.getWorkers().add(worker);
        carRepository.save(car);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
