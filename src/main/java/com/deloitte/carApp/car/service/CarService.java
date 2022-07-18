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

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    private ModelMapper modelMapper;

    public GetCarDto getCarDto(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
        return modelMapper.map(car, GetCarDto.class);
    }

    public Car findCar(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public GetCarDto findCarByCarTypeAndBrand(String type, String brand) {
        Car car = carRepository
                .findCarByCarTypeAndBrand(type, brand)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
        return modelMapper.map(car, GetCarDto.class);
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
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public Car saveCar(CreateCarDto createCarDto) {
        return carRepository.save(modelMapper.map(createCarDto, Car.class));
    }

    @Transactional
    public Car assignWorkerToCar(Car car, Worker worker) {
        car.getWorkers().add(worker);
        return carRepository.save(car);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
