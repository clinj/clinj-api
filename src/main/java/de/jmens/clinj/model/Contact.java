package de.jmens.clinj.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.List;

public class Contact {

	private String id;
	private String name;
	private List<String> directDial;
	private List<String> emails;
	private List<String> fax;
	private List<String> landline;
	private List<String> mobile;

	public void setId(String id) {
		this.id = id;
	}

	public void setDirectDial(List<String> directDial) {
		this.directDial = directDial;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public void setFax(List<String> fax) {
		this.fax = fax;
	}

	public void setLandline(List<String> landline) {
		this.landline = landline;
	}

	public void setMobile(List<String> mobile) {
		this.mobile = mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getDirectDial() {
		return directDial;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<String> getFax() {
		return fax;
	}

	public List<String> getLandline() {
		return landline;
	}

	public List<String> getMobile() {
		return mobile;
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
