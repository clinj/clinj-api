package de.jmens.clinj.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Credentials {

	private String user;
	private transient byte[] password;

	public Credentials(String user, byte[] password) {
		this.user = user;
		this.password = password;
	}

	public Credentials(String user, String password) {
		this.user = user;
		this.password = password.getBytes();
	}

	public String getUser() {
		return user;
	}

	public byte[] getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return reflectionToString(this, SHORT_PREFIX_STYLE, false);
	}

	@Override
	public boolean equals(final Object o) {
		return reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}
}
