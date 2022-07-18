package com.deloitte.carApp.initializer;

import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.client.service.ClientService;
import com.deloitte.carApp.facility.service.FacilityService;
import com.deloitte.carApp.rent.service.RentService;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class DataInitializer {

    private CarService carService;

    private FacilityService facilityService;

    private WorkerService workerService;

    private ClientService clientService;

    private RentService rentService;

    @PostConstruct
    public void initData() {
//
//        Car car1 = Car.builder()
//                .brand("a")
//                .carType("b")
//                .build();
//
//        Car car2 = Car.builder()
//                .brand("c")
//                .carType("d")
//                .build();
//
//        carService.saveCar(car1);
//        carService.saveCar(car2);
//
//        Facility facility1 = Facility.builder()
//                .phoneNumber("11111")
//                .build();
//        Facility facility2 = Facility.builder()
//                .phoneNumber("22222")
//                .build();
//
//        facilityService.saveFacility(facility1);
//        facilityService.saveFacility(facility2);
//
//        Worker worker1 = Worker.builder()
//                .name("worker1")
//                .facility(facility1)
//                .occupation(Occupation.SALES_MAN.getOccupation())
//                .build();
//
//        Worker worker2 = Worker.builder()
//                .name("worker2")
//                .facility(facility1)
//                .occupation(Occupation.SALES_MAN.getOccupation())
//                .build();
//
//        workerService.saveWorker(worker1);
//        workerService.saveWorker(worker2);
//
//        Client client1 = Client
//                .builder()
//                .name("client")
//                .build();
//
//        clientService.saveClient(client1);
//
//        Rent rent1 = Rent
//                .builder()
//                .client(client1)
//                .startFacility(facility1)
//                .endFacility(facility2)
//                .build();
//
//        rentService.saveRent(rent1);
//
//        //Why can't I use car1 and car2 (ID is created but associations not)
//        Car car_tmp = carService.findCarById(car1.getId());
//        Worker worker_tmp = workerService.findWorkerById(worker1.getId());
//        carService.assignWorkerToCar(car_tmp, worker_tmp);
//        carService.assignWorkerToCar(car_tmp, worker2);
//        Car car_tmp2 = carService.findCarById(car1.getId());
//        System.out.println(car_tmp2.getWorkers());
//
////        Facility facility_tmp = facilityService.findFacility(facility1.getId());
////        facilityService.addWorkerToFacility(facility_tmp, worker1);
//
//
//        List<Car> carsByWorker = carService.findCarsByWorker(workerService.findWorkerById(worker1.getId()));
//        System.out.println(carsByWorker);
//        facilityService.findAllFacilityWorkersByCar(car1);
    }
}
