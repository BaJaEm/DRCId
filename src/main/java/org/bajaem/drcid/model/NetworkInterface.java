package org.bajaem.drcid.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.bajaem.drcid.util.converters.BooleanToStringConverter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class NetworkInterface implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private Host host;
	private String ipAddress;
	private String netmask;
	private String name;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
	public Host getHost() {
		return host;
	}

	public void setHost(Host _host) {
		host = _host;
	}

	@Column(name="ip_address", nullable = false, length = 255)
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String _ipAddress) {
		ipAddress = _ipAddress;
	}

	@Column(name="net_mask", nullable = false, length = 255)
	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String _netmask) {
		netmask = _netmask;
	}

	@Column(name="name", nullable = false, length = 255)
	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
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
}
