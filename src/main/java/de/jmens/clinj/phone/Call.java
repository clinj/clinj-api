package de.jmens.clinj.phone;


import de.jmens.clinj.model.SipContact;
import java.util.concurrent.CompletableFuture;

/**
 * Base interface for every phone call.
 * #Call is supposed to be 'abstractish' and is extended by {@link InboundCall} and @{@link OutboundCall}
 * to represent calls with a proper direction.
 */
public interface Call {

	/**
	 * @return Future that will be completed if this call gets terminated by any cause.
	 */
	CompletableFuture<Boolean> terminationFuture();

	/**
	 * @return Future that will be completed if this call gets terminated by the remote party.
	 */
	CompletableFuture<Boolean> remoteHangupFuture();

	/**
	 * @return Unique id of this call.
	 */
	String getCallId();

	/**
	 * @return Contact of this calls originator.
	 */
	SipContact getCaller();


	/**
	 * @return Contact of this calls destination.
	 */
	SipContact getCallee();

	/**
	 * Terminates the call. This is "hang up the phone".
	 */
	void hangup();
}
