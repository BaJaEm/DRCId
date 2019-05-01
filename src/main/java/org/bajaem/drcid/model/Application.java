package org.bajaem.drcid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class Application implements Deleteable {

	private long id;

	private int externalId;

	private String name;

	private String owner;

	private String mailingList;

	private boolean isLogicallyDeleted;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generator")
	public long getId() {
		return id;
	}

	public void setId(final long _id) {
		id = _id;
	}

	public int getExternalId() {
		return externalId;
	}

	public void setExternalId(int _externalId) {
		externalId = _externalId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String _name) {
		name = _name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(final String _owner) {
		owner = _owner;
	}

	public String getMailingList() {
		return mailingList;
	}

	public void setMailingList(final String _mailingList) {
		mailingList = _mailingList;
	}

	public boolean isLogicallyDeleted() {
		return isLogicallyDeleted;
	}

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted) {
		isLogicallyDeleted = _isLogicallyDeleted;
	}

}
