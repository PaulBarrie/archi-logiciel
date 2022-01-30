package org.esgi.trademe.project.infrastructure;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.project.domain.ProjectStatus;
import org.esgi.trademe.project.exposition.ProjectRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryProjectRepository implements ProjectRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ProjectID, Project> data = new ConcurrentHashMap<>();


    @Override
    public List<Project> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public Project update(ProjectID contractID, Project contract) {
        return null;
    }

    @Override
    public List<Project> findByContractor(ContractorID contractorID) {
        return List.copyOf(data.values().stream()
                .filter(contract -> contract.getContractorID() == contractorID)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Project> findByStatus(ProjectStatus status) {
        return List.copyOf(data.values().stream()
                .filter(contract -> contract.getContractStatus() == status)
                .collect(Collectors.toList()));
    };
    

    @Override
    public ProjectID nextIdentity() {
        return ProjectID.of(count.incrementAndGet());
    }

    @Override
    public Project findById(ProjectID id) throws NoSuchEntityException {
        final Project contract = data.get(id);
        if (contract == null) {
            throw NoSuchEntityException.withId(id);
        }
        return contract;
    }

    @Override
    public void add(Project entity) {
        data.put(entity.getProjectID(), entity);
    }

    @Override
    public void delete(ProjectID id) {

    }
}
