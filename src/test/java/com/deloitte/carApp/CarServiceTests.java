package com.deloitte.carApp;


import com.deloitte.carApp.car.dto.CarDto;
import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.worker.entity.Worker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(value = "/scripts/testDataInit.sql",
        executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/scripts/testDataCleanUp.sql",
        executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class CarServiceTests {

    @Autowired
    private CarService carService;

    @Test
    void shouldFindCarsByWorker() {
        Worker worker = Worker.builder().id(1L).build();
        List<CarDto> cars = carService.findCarsByWorker(worker);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars).isNotNull();
        assertThat(cars.stream().allMatch(getCarDto ->
                getCarDto.getBrand().equals("Mercedes"))).isTrue();
    }

    @Test
    void shouldFindCarByBrandAndType() {
        CarDto car = carService.findCarByCarTypeAndBrand("Suv", "Mazda");
        assertThat(car.getColor()).isEqualTo("Blue");
        assertThat(car.getMileage()).isEqualTo(86531);
        assertThat(car.getProductionYear()).isEqualTo(2017);
        assertThat(car.getEngine()).isEqualTo("2.0");
    }

    @Test
    void shouldReturnCarsRentedMoreThan10Times() {
        List<CarDto> cars = carService.findCarsRentedMoreThan10Times();
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars).isNotNull();
        assertThat(cars.stream().allMatch(getCarDto ->
                getCarDto.getBrand().equals("Mercedes"))).isTrue();
    }

    @Test
    void shouldUpdateCar() {
        CarDto carDto = CarDto.builder()
                .carType("Suv")
                .brand("Mazda")
                .engine("2.0")
                .color("Brown")
                .build();
        carService.updateCar(1L, carDto);
        Car car = carService.findCar(1L);
        assertThat(car.getColor()).isEqualTo("Brown");
        assertThat(car.getCarType()).isEqualTo("Suv");
        assertThat(car.getBrand()).isEqualTo("Mazda");
        assertThat(car.getEngine()).isEqualTo("2.0");
    }
}
