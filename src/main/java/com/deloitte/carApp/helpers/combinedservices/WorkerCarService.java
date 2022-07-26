package com.deloitte.carApp.helpers.combinedservices;

import com.deloitte.carApp.car.dto.CarDto;
import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerCarService {

    private WorkerService workerService;

    private CarService carService;

    /*
        Should I return newly added resource or object that the resource was assigned to?
     */
    @Transactional
    public Worker assignWorkerToCar(Long carId, Long workerId) {
        Car car = carService.findCar(carId);
        Worker worker = workerService.findWorker(workerId);
        worker.getWorkerCars().add(car);
        workerService.saveWorker(worker);
        return worker;
    }

    public List<CarDto> findCarsByWorker(Long workerId) {
        return carService.findCarsByWorker(workerService.findWorker(workerId));
    }

    public List<WorkerDto> findWorkersByCar(Long carId) {
        return workerService.findWorkersByCar(carService.findCar(carId));
    }
}
