package de.jmens.clinj.model;

import static java.text.MessageFormat.format;

/**
 * A simple container for username / password combinations.
 */
public class Credentials {

	/**
	 * Holds an username used to authenticate somewhere.
	 */
	private String user;

	/**
	 * Holds a password used to authenticate somewhere.
	 */
	private transient byte[] password;

	/**
	 * Builds a new Credentials instantiation.
	 *
	 * @param user username part for this credentials.
	 * @param password password part for this credentials.
	 */
	public Credentials(String user, byte[] password) {
		this.user = user;
		this.password = password;
	}
	/**
	 * Builds a new Credentials instantiation.
	 *
	 * @param user username part for this credentials.
	 * @param password password part for this credentials.
	 */
	public Credentials(String user, String password) {
		this.user = user;
		this.password = password.getBytes();
	}

	/**
	 * @return This credentials {{@link #user}}
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return This credentials {{@link #password}}
	 */
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
