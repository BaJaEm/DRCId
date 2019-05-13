package org.bajaem.drcid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class DatabasePlatform implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private String databaseType;
	private String version;
	private String vendor;
	

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String _databaseType) {
		databaseType = _databaseType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String _version) {
		version = _version;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String _vendor) {
		vendor = _vendor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generator")
	public long getId() {
		return id;
	}

	public void setId(final long _id) {
		id = _id;
	}

	public boolean isLogicallyDeleted() {
		return isLogicallyDeleted;
	}

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted) {
		isLogicallyDeleted = _isLogicallyDeleted;
	}
}
