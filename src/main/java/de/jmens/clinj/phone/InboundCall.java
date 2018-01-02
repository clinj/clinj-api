package de.jmens.clinj.phone;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public interface InboundCall extends Call {

	CompletableFuture<Boolean> terminationFuture();

	void pickup();
}
