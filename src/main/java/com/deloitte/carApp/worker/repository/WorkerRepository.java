package com.deloitte.carApp.worker.repository;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT w FROM Worker w WHERE w.facility = ?1")
    List<Worker> findWorkersByFacility(Facility facility);

    @Query("SELECT w FROM Worker w WHERE ?1 MEMBER OF w.workerCars")
    List<Worker> findWorkersByCar(Car car);

}
