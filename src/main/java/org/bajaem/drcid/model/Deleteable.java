package org.bajaem.drcid.model;

public interface Deleteable {
	public boolean isLogicallyDeleted();

	public void setLogicallyDeleted(final boolean _isLogicallyDeleted);
}
