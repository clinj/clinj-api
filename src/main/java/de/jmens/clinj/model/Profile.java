package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

/**
 * Represents a sipgate telephony profile. The profile is formerly known as person-callgroup.
 * A profile is used to group several telephony endpoints to one physical person.
 */
public class Profile {

	/**
	 * The acocunt wide unique id of this profile. Something like <code>p0</code> or <code>p1</code> or similar.
	 */
	private String id;

	/**
	 * A user provided arbitrary alias of this profile. This can be any name like <code>John</code> or <code>Jane</code>
	 */
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
