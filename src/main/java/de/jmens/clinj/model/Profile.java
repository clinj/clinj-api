package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

/**
 * Represents a sipgate telephony profile, formerly known as person-callgroup.
 * A profiles main purpose is used to group several telephony endpoints to one physical person.
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

	/**
	 * Constructs a new Profile instance.
	 * @param id Profile id. Something like <code>p0</code> or <code>p1</code>.
	 * @param alias A user provided alias. Someting likd <code>Jane</code> or <code>John</code>;
	 */
	public Profile(String id, String alias) {
		this.id = id;
		this.alias = alias;
	}

	/**
	 * @return This profiles {{@link #id}}
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return This profiles {{@link #alias}}
	 */
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
