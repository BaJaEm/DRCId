package org.bajaem.drcid.repository;

import org.bajaem.drcid.model.NetworkInterface;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface NetworkInterfaceRepository  extends PagingAndSortingRepository<NetworkInterface, Long>{

}
