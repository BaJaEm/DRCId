package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.Site;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface SiteRepository  extends PagingAndSortingRepository<Site, Long>{

}
