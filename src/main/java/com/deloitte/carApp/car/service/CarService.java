package com.deloitte.carApp.car.service;

import com.deloitte.carApp.car.dto.CreateCarDto;
import com.deloitte.carApp.car.dto.GetCarDto;
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

    public GetCarDto findCarByCarTypeAndBrand(String type, String brand) {
        Car car = carRepository
                .findCarByCarTypeAndBrand(type, brand)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
        return modelMapper.map(car, GetCarDto.class);
    }

    public List<GetCarDto> findCarsByWorker(Worker worker) {
        return carRepository
                .findCarsByWorker(worker)
                .stream()
                .map(car -> modelMapper.map(car, GetCarDto.class))
                .collect(Collectors.toList());
    }

    public List<GetCarDto> findAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(car -> modelMapper.map(car, GetCarDto.class))
                .collect(Collectors.toList());
    }

    public List<GetCarDto> findCarsRentedMoreThan10Times() {
        return carRepository
                .findCarsRentedMoreThan10Times()
                .stream()
                .map(car -> modelMapper.map(car, GetCarDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Car saveCar(CreateCarDto createCarDto) {
        return carRepository.save(modelMapper.map(createCarDto, Car.class));
    }

    public Car updateCar(Long carId, CreateCarDto createCarDto) {
        Car car = findCar(carId);
        car.setCarType(createCarDto.getCarType());
        car.setBrand(createCarDto.getBrand());
        car.setColor(createCarDto.getColor());
        car.setEngine(createCarDto.getEngine());
        car.setMileage(createCarDto.getMileage());
        car.setPower(createCarDto.getPower());
        car.setProductionYear(createCarDto.getProductionYear());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
