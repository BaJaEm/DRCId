package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Application;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ApplicationRepository  extends PagingAndSortingRepository<Application, Long>{

}
