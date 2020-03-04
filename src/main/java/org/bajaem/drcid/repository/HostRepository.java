package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Host;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface HostRepository  extends PagingAndSortingRepository<Host, Long>{

}
