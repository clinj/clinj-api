package de.jmens.clinj.phone;


import de.jmens.clinj.model.SipContact;
import java.util.concurrent.CompletableFuture;

/**
 * Base interface for every phone call.
 */
public interface Call {
	CompletableFuture<Boolean> terminationFuture();
	CompletableFuture<Boolean> remoteHangupFuture();

	String getCallId();
	SipContact getCaller();
	SipContact getCallee();

	void hangup();
}
