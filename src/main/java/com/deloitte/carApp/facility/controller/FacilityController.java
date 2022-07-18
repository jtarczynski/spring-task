package com.deloitte.carApp.facility.controller;

import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.facility.dto.CreateFacilityDto;
import com.deloitte.carApp.facility.dto.GetFacilityDto;
import com.deloitte.carApp.facility.service.FacilityAddressService;
import com.deloitte.carApp.facility.service.FacilityService;
import com.deloitte.carApp.facility.service.FacilityWorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facilities")
@AllArgsConstructor
public class FacilityController {

    private FacilityService facilityService;

    private FacilityAddressService facilityAddressService;

    private FacilityWorkerService facilityWorkerService;

    @GetMapping("")
    public ResponseEntity<List<GetFacilityDto>> getAllFacilities() {
        return ResponseEntity.ok(facilityService.findAllFacilities());
    }

    @GetMapping("/facilityId/{facilityId}")
    public ResponseEntity<GetFacilityDto> getFacility(@PathVariable("facilityId") Long facilityId) {
        return ResponseEntity.ok(facilityService.getFacilityDto(facilityId));
    }

    @PostMapping("/add-facility")
    public ResponseEntity<Facility> addFacility(@RequestBody CreateFacilityDto createFacilityDto) {
        return ResponseEntity.ok(facilityAddressService.saveAddressFacility(createFacilityDto));
    }

    @PostMapping("/assign-worker/facilityId/{facilityId}/workerId/{workerId}")
    public ResponseEntity<Worker> addWorkerToFacility(@PathVariable("facilityId") Long facilityId,
                                                      @PathVariable("workerId") Long workerId) {
        return ResponseEntity.ok(facilityWorkerService.addWorkerToFacility(facilityId, workerId));
    }

    @DeleteMapping("delete-facility/facilityId/{facilityId}")
    public ResponseEntity<Void> deleteFacility(@PathVariable("facilityId") Long facilityId) {
        facilityService.deleteFacility(facilityId);
        return ResponseEntity.accepted().build();
    }
}
