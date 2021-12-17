package org.esgi.trademe.project.infrastructure;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.project.domain.ProjectStatus;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;

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
    public Project update(ProjectID projectID, Project project) {
        return null;
    }

    @Override
    public List<Project> findByContractor(ContractorID contractorID) {
        return List.copyOf(data.values().stream()
                .filter(project -> project.getContractorID() == contractorID)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Project> findByStatus(ProjectStatus status) {
        return List.copyOf(data.values().stream()
                .filter(project -> project.getContractStatus() == status)
                .collect(Collectors.toList()));
    };
    

    @Override
    public ProjectID nextIdentity() {
        return ProjectID.of(count.incrementAndGet());
    }

    @Override
    public Project findById(ProjectID id) throws NoSuchEntityException {
        final Project project = data.get(id);
        if (project == null) {
            throw NoSuchEntityException.withId(id);
        }
        return project;
    }

    @Override
    public void add(Project entity) {
        data.put(entity.getContractID(), entity);
    }

    @Override
    public void delete(ProjectID id) {

    }
}
