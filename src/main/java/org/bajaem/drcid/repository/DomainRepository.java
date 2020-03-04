package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Domain;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface DomainRepository  extends PagingAndSortingRepository<Domain, Long>{

}
