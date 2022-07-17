package com.deloitte.carApp.service;

import com.deloitte.carApp.dto.CreateCarDto;
import com.deloitte.carApp.dto.GetCarDto;
import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    private ModelMapper modelMapper;

    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public Car findCarByCarTypeAndBrand(String type, String brand) {
        return carRepository
                .findCarByCarTypeAndBrand(type, brand)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Car> findCarsByWorker(Worker worker) {
        return carRepository.findCarsByWorker(worker);
    }

    public List<GetCarDto> findAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, GetCarDto.class))
                .toList();
    }

    @Transactional
    public void saveCar(Long id) {
        carRepository.save(findCarById(id));
    }

    @Transactional
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Transactional
    public void saveCar(CreateCarDto createCarDto) {
        carRepository.save(modelMapper.map(createCarDto, Car.class));
    }

    @Transactional
    public void assignWorkerToCar(Car car, Worker worker) {
        car.getWorkers().add(worker);
        carRepository.save(car);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
