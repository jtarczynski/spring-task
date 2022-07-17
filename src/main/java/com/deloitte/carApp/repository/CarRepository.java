package com.deloitte.carApp.repository;

import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c from Car c WHERE c.carType = ?1 AND c.brand = ?2")
    Optional<Car> findCarByCarTypeAndBrand(String type, String brand);


    @Query("SELECT c FROM Car c WHERE ?1 MEMBER OF c.workers")
    List<Car> findCarsByWorker(Worker worker);

}
