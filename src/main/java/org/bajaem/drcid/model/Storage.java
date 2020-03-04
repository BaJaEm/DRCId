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
public class Storage implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private String name;
	private String path;
	private String type; // Make this an enum?

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generator")
	public long getId() {
		return id;
	}


	public void setId(final long _id) {
		id = _id;
	}

	@Column(nullable = false)
	@Convert(converter = BooleanToStringConverter.class)
	@Check(constraints = "IN ('T', 'F')")
	@ColumnDefault(value = "F")
	public boolean isLogicallyDeleted() {
		return isLogicallyDeleted;
	}

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted) {
		isLogicallyDeleted = _isLogicallyDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(final String _name) {
		name = _name;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(final String _path) {
		path = _path;
	}

	public String getType() {
		return type;
	}

	public void setType(final String _type) {
		type = _type;
	}

}
