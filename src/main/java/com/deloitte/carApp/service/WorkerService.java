package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.HumanType;
import com.deloitte.carApp.entity.Rent;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.RentRepository;
import com.deloitte.carApp.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void saveWorkerById(Long id) {
        workerRepository.save(findWorkerById(id));
    }

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public void deleteWorkerById(Long id) {
        workerRepository.deleteById(id);
    }
}
