package org.bajaem.drcid.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.bajaem.drcid.util.converters.BooleanToStringConverter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class Host implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private Set<Environment> environments;
	private Set<NetworkInterface> networkInterfaces;
	private OperatingSytstem operatingSystem;
	private DataCenter dataCenter;
	private String hostName;
	private Domain domain;
	private short memory;
	private short cpuCount;
	
	@ManyToMany(mappedBy = "hosts")
	public Set<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Set<Environment> _environments) {
		environments = _environments;
	}

    @ManyToOne
    @JoinColumn(name = "operating_system_id", nullable = false)
	public OperatingSytstem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSytstem _operatingSystem) {
		operatingSystem = _operatingSystem;
	}

    @ManyToOne
    @JoinColumn(name = "data_center_id", nullable = false)
	public DataCenter getDataCenter() {
		return dataCenter;
	}

	public void setDataCenter(DataCenter _dataCenter) {
		dataCenter = _dataCenter;
	}

	@Column(name="host_name", nullable = false, length = 255, unique = true)
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String _hostName) {
		hostName = _hostName;
	}

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain _domain) {
		domain = _domain;
	}

	@Column(name="memory", nullable = true)
	public short getMemory() {
		return memory;
	}

	public void setMemory(short _memory) {
		memory = _memory;
	}

	@Column(name="cpu_count", nullable = true)
	public short getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(short _cpuCount) {
		cpuCount = _cpuCount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generator")
	public long getId() {
		return id;
	}

	public void setId(final long _id) {
		id = _id;
	}

	@Column(name="logically_deleted", nullable = false)
    @Convert(converter = BooleanToStringConverter.class)
	@Check(constraints = "IN ('T', 'F')")
	@ColumnDefault(value = "F")
	public boolean isLogicallyDeleted() {
		return isLogicallyDeleted;
	}

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted) {
		isLogicallyDeleted = _isLogicallyDeleted;
	}

	@OneToMany(mappedBy="host")
	public Set<NetworkInterface> getNetworkInterfaces() {
		return networkInterfaces;
	}

	public void setNetworkInterfaces(Set<NetworkInterface> _networkInterfaces) {
		networkInterfaces = _networkInterfaces;
	}
}
