package com.deloitte.carApp.repository;

import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {





}
