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
public class LevelDesignator implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private String name;
	private String description;

	
	@Column(name="name", nullable = false, length = 25, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	@Column(name="description", nullable = true, length = 255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String _description) {
		description = _description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generator")
	public long getId() {
		return id;
	}

	public void setId(final long _id) {
		id = _id;
	}

	@Column(name="logically_deleted",nullable = false)
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
