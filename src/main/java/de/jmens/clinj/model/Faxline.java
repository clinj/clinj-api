package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

/**
 * Represents a sipgate fax line. Fax lines are used to send fax messages.
 */
public class Faxline {

	/**
	 * Id of this fax line. Something like <code>f0</code> or <code>f1</code>.
	 */
	private String id;

	/**
	 * Indicates if this fax line is in condition to send fax messages.
	 */
	private Boolean canSend;

	/**
	 * Indicates if this fax line is in condition to receive fax messages.
	 */
	private Boolean canReceive;

	/**
	 * User provided name of this faxlines. Something like <code>Fax Office</code>.
	 */
	private String alias;

	/**
	 * User provided part of the tagline applied to each outgoing fax message.
	 */
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
