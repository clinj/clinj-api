package de.jmens.clinj.model;

/**
 * Base interface for contact information transported with SIP packages, e.g. in <code>from</code>or <code>to</code> fields.
 */
public interface SipContact {

	/**
	 * @return String value representing a human readable version of this contact.
	 */
	String getContact();

	/**
	 * @return String value representing the unmodified contact information.
	 */
	String getFormattedContact();
}
