package com.deloitte.carApp.repository;

import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT w FROM Worker w WHERE w.facility = ?1")
    List<Worker> findWorkersByFacility(Facility facility);

}
