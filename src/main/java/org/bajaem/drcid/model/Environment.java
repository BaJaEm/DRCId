package org.bajaem.drcid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "Generator", sequenceName = "key_seq", allocationSize = 1)
public class Environment implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private Application application;
	private Level level;
	private Site site;

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
    @JoinColumn(name = "site_id", nullable = false)
	public Site getSite() {
		return site;
	}

	public void setSite(Site _site) {
		site = _site;
	}
}
