package de.jmens.clinj.phone;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface OutboundCall extends Call {

	CompletableFuture<String> dial();

	CompletableFuture<Boolean> remoteRingingFuture();

	CompletableFuture<Boolean> remotePickedUpFuture();

	void calleePickup(String callId);

	CompletableFuture<Boolean> remoteHangupFuture();
}
