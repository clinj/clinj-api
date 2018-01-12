package de.jmens.clinj.phone;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface OutboundCall extends Call {

	/**
	 * @return Initiates a new call. An #OutboundCall can be prepared and executed later using {@link #dial()}. If called, the phone tries to
	 * establish a phone call to the remote party.
	 */
	CompletableFuture<String> dial();

	/**
	 * @return Future that will be completed if the called remote phone rings.
	 */
	CompletableFuture<Boolean> remoteRingingFuture();

	/**
	 * @return Future that will be completed if the remote party picks up the call. After completion, the session is established and working.
	 */
	CompletableFuture<Boolean> remotePickedUpFuture();

	/**
	 * @return Future that will be completed if the remote party terminates the call. This is 'hanging up the phone'.
	 */
	CompletableFuture<Boolean> remoteHangupFuture();
}
