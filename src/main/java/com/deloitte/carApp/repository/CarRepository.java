package com.deloitte.carApp.repository;

import com.deloitte.carApp.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByCarTypeAndBrand(String type, String brand);


//    @Query("SELECT c FROM Car c" +
//            "LEFT JOIN Worker W on W.id = ")
//    List<Car> findCarByWorker(Long workerId);

}
