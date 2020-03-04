package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.OperatingSytstem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface OperatingSytstemRepository  extends PagingAndSortingRepository<OperatingSytstem, Long>{

}
