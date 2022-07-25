package com.deloitte.carApp.worker.controller;

import com.deloitte.carApp.helpers.combinedservices.WorkerCarService;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.human.service.HumanService;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/workers/")
@AllArgsConstructor
public class WorkerController {

    private WorkerService workerService;

    private WorkerCarService workerCarService;
    private HumanService humanService;

    @GetMapping("all")
    public String getAllWorkers(Model model) {
        model.addAttribute("workers", workerService.findAllWorkers());
        return "workersView";
    }

    @GetMapping("worker-id/{workerId}")
    public ResponseEntity<WorkerDto> getWorker(@PathVariable("workerId") Long workerId) {
        return ResponseEntity.ok(workerService.getWorkerDto(workerId));
    }

    @GetMapping("car-id/{carId}")
    public ResponseEntity<List<WorkerDto>> getWorkersByCar(@PathVariable("carId") Long carId) {
        return ResponseEntity.ok(workerCarService.findWorkersByCar(carId));
    }

    @PostMapping("add-worker")
    public ResponseEntity<Worker> addWorker(@RequestBody WorkerDto workerDto) {
        return ResponseEntity.ok(humanService.saveWorker(workerDto));
    }
}
