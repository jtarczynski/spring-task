package com.deloitte.carApp;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.facility.service.FacilityService;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.entity.Worker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(value = "/scripts/testDataInit.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/scripts/testDataCleanUp.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class FacilityServiceTests {

    @Autowired
    private FacilityService facilityService;

    @Test
    void shouldFindAllFacilityWorkersAssignedToSpecificCar() {
        List<WorkerDto> workers = facilityService.findAllFacilityWorkersByCar(1L, 1L);
        assertThat(workers.size()).isEqualTo(2);
        assertThat(workers).isNotNull();
    }

    @Test
    void shouldFindAllFacilityWorkers() {
        List<WorkerDto> workers = facilityService.findAllFacilityWorkers(2L);
        assertThat(workers.size()).isEqualTo(1);
        assertThat(workers).isNotNull();
    }

    @Test
    void shouldAssignWorkerToFacility() {
        Worker worker = facilityService.assignWorkerToFacility(1L, 4L);
        Facility facility = Facility.builder().id(1L).build();
        assertThat(worker.getFacility()).isEqualTo(facility); //lazy init ?
    }


}
