package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

public class Faxline {

	private String id;
	private Boolean canSend;
	private Boolean canReceive;
	private String alias;
	private String tagline;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCanSend(Boolean canSend) {
		this.canSend = canSend;
	}

	public void setCanReceive(Boolean canReceive) {
		this.canReceive = canReceive;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	public int hashCode() {
		return id == null ? -1 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return id == null ? false : id.equals(obj);
	}

	@Override
	public String toString() {
		return format("Faxline[id:{0}]", id);
	}
}
