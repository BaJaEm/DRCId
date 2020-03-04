package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Storage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface StorageRepository  extends PagingAndSortingRepository<Storage, Long>{

}
