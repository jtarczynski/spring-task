package com.deloitte.carApp.worker.service;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkerService {
    private WorkerRepository workerRepository;

    private ModelMapper modelMapper;

    public Worker findWorker(Long id) {
        return workerRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.WORKER_NOT_FOUND));
    }

    public WorkerDto getWorkerDto(Long id) {
        return modelMapper.map(findWorker(id), WorkerDto.class);
    }

    public List<WorkerDto> findAllWorkers() {
        return workerRepository.findAll()
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .collect(Collectors.toList());
    }

    public List<WorkerDto> findWorkersByCar(Car car) {
        return workerRepository.findWorkersByCar(car)
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .collect(Collectors.toList());
    }

    public List<Worker> findWorkersByFacility(Facility facility) {
        return workerRepository.findWorkersByFacility(facility);
    }

    @Transactional
    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Transactional
    public void removeWorkerFromFacility(Long workerId) {
        Worker worker = findWorker(workerId);
        worker.setFacility(null);
        workerRepository.save(worker);
    }
}
