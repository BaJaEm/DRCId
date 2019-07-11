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
public class Level implements Deleteable {

	private long id;
	private boolean isLogicallyDeleted;
	private String name;
	private LevelDesignator levelDesignator;
	private String description;

	public String getName() {
		return name;
	}

	public void setname(String _name) {
		name = _name;
	}
    @ManyToOne
    @JoinColumn(name = "level_designator_id", nullable = false)
	public LevelDesignator getLevelDesignator() {
		return levelDesignator;
	}

	public void setLevelDesignator(LevelDesignator _levelDesignator) {
		levelDesignator = _levelDesignator;
	}

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

	public boolean isLogicallyDeleted() {
		return isLogicallyDeleted;
	}

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted) {
		isLogicallyDeleted = _isLogicallyDeleted;
	}
}
