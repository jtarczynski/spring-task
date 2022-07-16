package com.deloitte.carApp.initializer;

import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.service.CarService;
import com.deloitte.carApp.service.FacilityService;
import com.deloitte.carApp.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class DataInitializer {

    private CarService carService;

    private FacilityService facilityService;

    private WorkerService workerService;

    @PostConstruct
    public void initData() {

        Car car1 = new Car();
        Car car2 = new Car();

        carService.saveCar(car1);
        carService.saveCar(car2);

        Facility facility1 = new Facility();
        Facility facility2 = new Facility();

        facilityService.saveFacility(facility1);
        facilityService.saveFacility(facility2);

        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        workerService.saveWorker(worker1);
        workerService.saveWorker(worker2);

        carService.assignWorkerToCar(car1.getId(), worker1);

        System.out.println(car1);
    }
}
