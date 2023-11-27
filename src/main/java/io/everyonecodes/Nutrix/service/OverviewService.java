package io.everyonecodes.Nutrix.service;

import io.everyonecodes.Nutrix.entity.Overview;
import io.everyonecodes.Nutrix.repository.OverviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverviewService {

    private OverviewRepository repository;

    public OverviewService(OverviewRepository repository) {
        this.repository = repository;
    }

    public List<Overview> getAll() {
        return repository.findAll();
    }


}
