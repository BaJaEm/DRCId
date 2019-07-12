package org.bajaem.drcid.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.bajaem.drcid.util.converters.BooleanToStringConverter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
        name="database_platform", 
        uniqueConstraints=  @UniqueConstraint(columnNames={"db_type", "version"})
)
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class DatabasePlatform implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private String databaseType;
	private String version;
	private String vendor;
	

	@Column(name="db_type", nullable = false, length = 255)
	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String _databaseType) {
		databaseType = _databaseType;
	}

	@Column(name="version", nullable = false, length = 255)
	public String getVersion() {
		return version;
	}

	public void setVersion(String _version) {
		version = _version;
	}

	@Column(name="vendor", nullable = true, length = 255)
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
