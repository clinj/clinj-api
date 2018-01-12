package de.jmens.clinj.phone;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Represents an inbound call.
 */
public interface InboundCall extends Call {

	/**
	 * Picks up an incoming call.
	 */
	void pickup();
}
