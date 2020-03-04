package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Level;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface LevelRepository  extends PagingAndSortingRepository<Level, Long>{

}
