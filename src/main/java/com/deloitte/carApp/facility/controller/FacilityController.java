package com.deloitte.carApp.facility.controller;

import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.facility.dto.FacilityDto;
import com.deloitte.carApp.facility.service.FacilityService;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facilities/")
@AllArgsConstructor
public class FacilityController {

    private FacilityService facilityService;
    private WorkerService workerService;

    @GetMapping("all")
    public ResponseEntity<List<FacilityDto>> getAllFacilities() {
        return ResponseEntity.ok(facilityService.findAllFacilities());
    }

    @GetMapping("facility-id/{facilityId}")
    public ResponseEntity<FacilityDto> getFacility(@PathVariable("facilityId") Long facilityId) {
        return ResponseEntity.ok(facilityService.getFacilityDto(facilityId));
    }

    @GetMapping("facility-id/{facilityId}/workers")
    public ResponseEntity<List<WorkerDto>> getFacilityWorkers(@PathVariable("facilityId") Long facilityId) {
        return ResponseEntity.ok(facilityService.findAllFacilityWorkers(facilityId));
    }

    @GetMapping("car-id/{carId}/")
    public ResponseEntity<List<WorkerDto>> getFacilityWorkersByCar(@PathVariable("carId") Long carId) {
        return ResponseEntity.ok(facilityService.findAllFacilityWorkersByCar(carId));
    }

    @PutMapping("update-facility/facility-id/{facilityId}/")
    public ResponseEntity<Facility> updateFacility(@PathVariable("facilityId") Long facilityId,
                                                   @RequestBody FacilityDto facilityDto) {
        return ResponseEntity.accepted().body(facilityService.updateFacility(facilityId, facilityDto));
    }

    @PostMapping("add-facility")
    public ResponseEntity<Facility> addFacility(@RequestBody FacilityDto facilityDto) {
        return ResponseEntity.ok(facilityService.saveFacilityFromDto(facilityDto));
    }

    @PostMapping("assign-worker/facility-id/{facilityId}/workerId/{workerId}")
    public ResponseEntity<Worker> addWorkerToFacility(@PathVariable("facilityId") Long facilityId,
                                                      @PathVariable("workerId") Long workerId) {
        return ResponseEntity.ok(facilityService.assignWorkerToFacility(facilityId, workerId));
    }

    @DeleteMapping("remove-worker/worker-id/{workerId}")
    public ResponseEntity<Void> removeWorkerFromFacility(@PathVariable("workerId") Long workerId) {
        workerService.removeWorkerFromFacility(workerId);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("delete-facility/facility-id/{facilityId}")
    public ResponseEntity<Void> deleteFacility(@PathVariable("facilityId") Long facilityId) {
        facilityService.deleteFacility(facilityId);
        return ResponseEntity.accepted().build();
    }
}
