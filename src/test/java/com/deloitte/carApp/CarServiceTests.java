package com.deloitte.carApp;


import com.deloitte.carApp.car.dto.GetCarDto;
import com.deloitte.carApp.car.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(value = "/scripts/carServiceTestScripts/CarServiceTestSetUp.sql",
        executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/scripts/carServiceTestScripts/CarServiceTestCleanUp.sql",
        executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class CarServiceTests {

    @Autowired
    private CarService carService;

//    @Test
//    void shouldFindCarsByWorker() {
//        GetCarDto car = carService.findCarsByWorker(1L);
//        assertThat(car.getColor()).isEqualTo("Blue");
//        assertThat(car.getMileage()).isEqualTo(86531);
//        assertThat(car.getProductionYear()).isEqualTo(2017);
//        assertThat(car.getEngine()).isEqualTo("2.0");
//    }

//    @Test
//    void shouldFindCarByBrandAndType() {
//        GetCarDto car = carService.findCarByCarTypeAndBrand("Suv", "Mazda");
//        assertThat(car.getColor()).isEqualTo("Blue");
//        assertThat(car.getMileage()).isEqualTo(86531);
//        assertThat(car.getProductionYear()).isEqualTo(2017);
//        assertThat(car.getEngine()).isEqualTo("2.0");
//    }
}
