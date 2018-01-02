package de.jmens.clinj.model;

import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;

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
		this.name = defaultString(name);
		this.profiles = ObjectUtils.defaultIfNull(profiles, emptyList());
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
	public String toString() {
		return reflectionToString(this, SHORT_PREFIX_STYLE);
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
