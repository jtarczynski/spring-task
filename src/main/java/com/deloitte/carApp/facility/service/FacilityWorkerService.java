package com.deloitte.carApp.facility.service;

import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class FacilityWorkerService {

    private FacilityService facilityService;

    private WorkerService workerService;

    @Transactional
    public Worker addWorkerToFacility(Long facilityId, Long workerId) {
        Facility facility = facilityService.findFacility(facilityId);
        Worker worker = workerService.findWorker(workerId);
        facility.getWorkers().add(worker); //Why Lazy Initialization exception?
        worker.setFacility(facility);
        workerService.saveWorker(worker);
        facilityService.saveFacility(facility);
        return worker;
    }
}
