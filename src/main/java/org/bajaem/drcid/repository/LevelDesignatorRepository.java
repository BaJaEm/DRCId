package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.LevelDesignator;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface LevelDesignatorRepository  extends PagingAndSortingRepository<LevelDesignator, Long>{

}
