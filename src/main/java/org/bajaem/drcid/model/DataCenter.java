package org.bajaem.drcid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class DataCenter implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private String name;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String _location) {
		location = _location;
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
