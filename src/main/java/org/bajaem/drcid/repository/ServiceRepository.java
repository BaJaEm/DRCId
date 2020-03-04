package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ServiceRepository  extends PagingAndSortingRepository<Service, Long>{

}
