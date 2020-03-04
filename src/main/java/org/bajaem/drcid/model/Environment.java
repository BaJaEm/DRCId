package org.bajaem.drcid.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.bajaem.drcid.util.converters.BooleanToStringConverter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class Environment implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private Application application;
	private Level level;
	private Site site;
	private Set<Database> databases;
	private Set<Host> hosts;
	private Set<Storage> storage;

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

	@ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application _application) {
		application = _application;
	}

	@ManyToOne
	@JoinColumn(name = "level_id", nullable = false)
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level _level) {
		level = _level;
	}

	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	public Site getSite() {
		return site;
	}

	public void setSite(Site _site) {
		site = _site;
	}

	@ManyToMany
	@JoinTable(name = "db_env")
	public Set<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(final Set<Database> _databases) {
		databases = _databases;
	}
	
	@ManyToMany
	@JoinTable(name = "host_env")
	public Set<Host> getHosts() {
		return hosts;
	}

	public void setHosts(final Set<Host> _hosts) {
		hosts = _hosts;
	}

	@ManyToMany
	@JoinTable(name = "storage_env")
	public Set<Storage> getStorage() {
		return storage;
	}

	public void setStorage(Set<Storage> _storage) {
		storage = _storage;
	}
}
