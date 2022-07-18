package com.deloitte.carApp.worker.service;

import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.worker.dto.GetWorkerDto;
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

    public GetWorkerDto getWorkerDto(Long id) {
        Worker worker = workerRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.WORKER_NOT_FOUND));
        return modelMapper.map(worker, GetWorkerDto.class);
    }

    public List<GetWorkerDto> findAllWorkers() {
        return workerRepository.findAll()
                .stream()
                .map(worker -> modelMapper.map(worker, GetWorkerDto.class))
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
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
