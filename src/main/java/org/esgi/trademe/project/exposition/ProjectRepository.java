package org.esgi.trademe.project.exposition;

import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.Repository;
import org.esgi.trademe.project.domain.ProjectStatus;

import java.util.List;

public interface ProjectRepository extends Repository<ProjectID, Project> {
    List<Project> findAll();
    Project findById(ProjectID id);
    Project update(ProjectID contractID, Project contract);
    List<Project> findByTradesman(TradesmanID tradesmanID);
    List<Project> findByStatus(ProjectStatus status);
}
