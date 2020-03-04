package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.DataCenter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface DataCenterRepository  extends PagingAndSortingRepository<DataCenter, Long>{

}
