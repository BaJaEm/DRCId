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
import javax.persistence.SequenceGenerator;

import org.bajaem.drcid.util.converters.BooleanToStringConverter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class Database implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private Set<Environment> environments;
	private String name;
	private int port;
	private String schema;
	private String connectionInformation;
	private Host host;
	private DatabasePlatform databasePlatform;
	

	@ManyToMany(mappedBy = "databases")
	public Set<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Set<Environment> _environments) {
		environments = _environments;
	}

	@Column(name="name", nullable = false, length = 255, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	@Column(name="port", nullable = false)
	public int getPort() {
		return port;
	}

	public void setPort(int _port) {
		port = _port;
	}

	@Column(name="schema", nullable = false, length = 255)
	public String getSchema() {
		return schema;
	}

	public void setSchema(String _schema) {
		schema = _schema;
	}

	@Column(name="connection_information", nullable = true, length = 255)
	public String getConnectionInformation() {
		return connectionInformation;
	}

	public void setConnectionInformation(String _connectionInformation) {
		connectionInformation = _connectionInformation;
	}

	@ManyToOne
	@JoinColumn(name = "host_id", nullable = false)
	public Host getHost() {
		return host;
	}

	public void setHost(Host _host) {
		host = _host;
	}

	@ManyToOne
	@JoinColumn(name = "database_platform_id", nullable = false)
	public DatabasePlatform getDatabasePlatform() {
		return databasePlatform;
	}

	public void setDatabasePlatform(DatabasePlatform _databasePlatform) {
		databasePlatform = _databasePlatform;
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
