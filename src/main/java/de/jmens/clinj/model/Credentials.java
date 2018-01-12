package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

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

	private String getHash() {
		StringBuilder builder = new StringBuilder();
		builder.append(user);
		builder.append(password == null ? "null" : new String(password));
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return getHash().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return getHash().equals(obj);
	}

	@Override
	public String toString() {
		return format("{0}[{1}:XXXXX]", getClass().getSimpleName(), user);
	}
}
