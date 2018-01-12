package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

public class Profile {

	private String id;
	private String alias;

	public Profile(String id, String alias) {
		this.id = id;
		this.alias = alias;
	}

	public String getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(obj);
	}

	@Override
	public String toString() {
		return format("{0}[id:{1}]", getClass().getSimpleName(), id);
	}
}
