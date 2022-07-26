package com.deloitte.carApp.car.service;

import com.deloitte.carApp.car.dto.CarDto;
import com.deloitte.carApp.car.repository.CarRepository;
import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    private ModelMapper modelMapper;

    public Car findCar(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    /*
        Should I return Dto or entity in all these methods?
     */
    public CarDto findCarByCarTypeAndBrand(String type, String brand) {
        Car car = carRepository
                .findCarByCarTypeAndBrand(type, brand)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
        return modelMapper.map(car, CarDto.class);
    }

    public List<CarDto> findCarsByWorker(Worker worker) {
        return carRepository
                .findCarsByWorker(worker)
                .stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    public List<CarDto> findAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    public List<CarDto> findCarsRentedMoreThan10Times() {
        return carRepository
                .findCarsRentedMoreThan10Times()
                .stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Car saveCar(CarDto carDto) {
        return carRepository.save(modelMapper.map(carDto, Car.class));
    }

    public Car updateCar(Long carId, CarDto carDto) {
        Car car = findCar(carId);
        car.setCarType(carDto.getCarType());
        car.setBrand(carDto.getBrand());
        car.setColor(carDto.getColor());
        car.setEngine(carDto.getEngine());
        car.setMileage(carDto.getMileage());
        car.setPower(carDto.getPower());
        car.setProductionYear(carDto.getProductionYear());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
