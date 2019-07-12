package org.bajaem.drcid.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.bajaem.drcid.util.converters.BooleanToStringConverter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;


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

	@Column(name="external_id", nullable = false, unique = true)
	public int getExternalId() {
		return externalId;
	}

	public void setExternalId(int _externalId) {
		externalId = _externalId;
	}

	@Column(name="name", nullable = false, unique = true, length = 255)
	public String getName() {
		return name;
	}

	public void setName(final String _name) {
		name = _name;
	}

	@Column(name="owner", nullable = true, length = 255)
	public String getOwner() {
		return owner;
	}

	public void setOwner(final String _owner) {
		owner = _owner;
	}

	@Column(name="mailing_list", nullable = true, length = 255)
	public String getMailingList() {
		return mailingList;
	}

	public void setMailingList(final String _mailingList) {
		mailingList = _mailingList;
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
