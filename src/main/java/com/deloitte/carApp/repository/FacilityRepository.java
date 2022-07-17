package com.deloitte.carApp.repository;

import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query("SELECT w FROM Facility f " +
            "JOIN Worker w on w.facility = f " +
            "WHERE w.workerCars IN ?1")
    List<Worker> findAllFacilityWorkersByCar(Car car);

}
