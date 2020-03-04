package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Database;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface DatabaseRepository  extends PagingAndSortingRepository<Database, Long>{

}
