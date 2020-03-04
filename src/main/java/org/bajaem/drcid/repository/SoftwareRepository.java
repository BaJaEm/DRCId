package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Software;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface SoftwareRepository extends PagingAndSortingRepository<Software, Long> {
}
