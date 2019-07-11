package org.bajaem.drcid.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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

	@ManyToMany
	public Set<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Set<Environment> _environments) {
		environments = _environments;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int _port) {
		port = _port;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String _schema) {
		schema = _schema;
	}

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

	public boolean isLogicallyDeleted() {
		return isLogicallyDeleted;
	}

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted) {
		isLogicallyDeleted = _isLogicallyDeleted;
	}
}
