package de.jmens.clinj.model;

import static java.text.MessageFormat.format;
import static java.util.Collections.emptyList;

import java.util.List;
import java.util.stream.Collectors;

public class Phoneline {

	private String id;
	private String name;
	private Credentials credentials;
	private List<Profile> profiles;

	public Phoneline(String id, String username, String password) {
		this(id, new Credentials(username, password), null, null);
	}

	public Phoneline(String id, String username, String password, String name) {
		this(id, new Credentials(username, password), name, null);
	}

	public Phoneline(String id, Credentials credentials, String name, List<Profile> profiles) {
		this.credentials = credentials;
		this.id = id;
		this.name = name == null ? "" : name;
		this.profiles = profiles == null ? emptyList() : profiles;
	}

	public String getUsername() {
		return credentials.getUser();
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return new String(credentials.getPassword());
	}

	public String getName() {
		return name;
	}

	public List<String> getProfileIds() {
		return profiles
				.stream()
				.map(connection -> connection.getId())
				.collect(Collectors.toList());
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
		return format("{0}[id:{1}", getClass().getSimpleName(), id);
	}
}
