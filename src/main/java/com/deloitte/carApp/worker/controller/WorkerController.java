package com.deloitte.carApp.worker.controller;

import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.human.service.HumanService;
import com.deloitte.carApp.worker.dto.CreateWorkerDto;
import com.deloitte.carApp.worker.dto.GetWorkerDto;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
@AllArgsConstructor
public class WorkerController {

    private WorkerService workerService;

    private HumanService humanService;

    @GetMapping("")
    public ResponseEntity<List<GetWorkerDto>> getAllFacilities() {
        return ResponseEntity.ok(workerService.findAllWorkers());
    }

    @GetMapping("/workerId/{workerId}")
    public ResponseEntity<GetWorkerDto> getWorker(@PathVariable("workerId") Long workerId) {
        return ResponseEntity.ok(workerService.getWorkerDto(workerId));
    }

    @PostMapping("/add-worker")
    public ResponseEntity<Worker> addWorker(@RequestBody CreateWorkerDto createWorkerDto) {
        return ResponseEntity.ok(humanService.saveWorker(createWorkerDto));
    }
}
