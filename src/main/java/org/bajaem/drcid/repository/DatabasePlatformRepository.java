package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.DatabasePlatform;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface DatabasePlatformRepository  extends PagingAndSortingRepository<DatabasePlatform, Long>{

}
