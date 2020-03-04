package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Environment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface EnvironmentRepository  extends PagingAndSortingRepository<Environment, Long>{

}
