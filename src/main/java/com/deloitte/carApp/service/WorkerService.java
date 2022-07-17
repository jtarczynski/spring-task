package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.HumanType;
import com.deloitte.carApp.entity.Rent;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.RentRepository;
import com.deloitte.carApp.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {
    private WorkerRepository workerRepository;

    public Worker findWorkerById(Long id) {
        return workerRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    public List<Worker> findWorkersByFacility(Facility facility) {
        return workerRepository.findWorkersByFacility(facility);
    }

    @Transactional
    public void saveWorker(Long id) {
        workerRepository.save(findWorkerById(id));
    }

    @Transactional
    public void saveWorker(Worker worker) {
        workerRepository.save(worker);
    }

    @Transactional
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
