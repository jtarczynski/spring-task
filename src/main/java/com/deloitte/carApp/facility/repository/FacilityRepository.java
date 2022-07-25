package com.deloitte.carApp.facility.repository;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query("SELECT w FROM Facility f " +
            "JOIN Worker w on w.facility = f " +
            "WHERE ?1 MEMBER OF w.workerCars")
    List<Worker> findAllFacilityWorkersByCar(Car car);

    @Query("SELECT w FROM Facility f " +
            "JOIN Worker w on w.facility = ?1")
    List<Worker> findAllFacilityWorkers(Facility facility);

}
