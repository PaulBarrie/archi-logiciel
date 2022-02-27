package org.esgi.trademe.project.exposition;

import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.Repository;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.project.domain.ProjectStatus;

import java.util.List;

public interface ProjectRepository extends Repository<ProjectID, Project> {
    List<Project> findAll();
    Project findById(ProjectID id);
    Project update(ProjectID contractID, Project contract);
    List<Project> findByContractor(ContractorID contractorID);
    List<Project> findByStatus(ProjectStatus status);
}
