package de.jmens.clinj.phone;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;

public interface ClinjPhone extends AutoCloseable {

	Logger LOGGER = getLogger(ClinjPhone.class);

	CompletableFuture<Boolean> register();

	OutboundCall newCall(String callee);

	ClinjPhone addInboundListener(InboundCallListener inboundListener);

	Collection<Call> getCalls();

	Collection<OutboundCall> getOutboundCalls();

	Collection<InboundCall> getInboundCalls();

	CompletableFuture<Boolean> shutdown();

	default Optional<InboundCall> getInboundCall(String callId) {
		return getInboundCalls()
				.stream()
				.filter(call -> call.getCallId().equals(callId))
				.findFirst();
	}

	default Optional<Call> getCall(String callId) {
		return getCalls()
				.stream()
				.filter(call -> call.getCallId().equals(callId))
				.findFirst();
	}

	default Optional<OutboundCall> getOutboundCall(String callId) {
		return getOutboundCalls()
				.stream()
				.filter(call -> call.getCallId().equals(callId))
				.findFirst();
	}

	static Optional<ClinjPhone> getPhone(String username, String password) {
		return getPhone(username, password, "de.jmens.clinj.phone.ClinjPhoneImpl");
	}

	static Optional<ClinjPhone> getPhone(String username, String password, String type) {
		try {
			final Class<? extends ClinjPhone> clazz = (Class<? extends ClinjPhone>) Class.forName(type);
			return Optional.ofNullable(clazz.getConstructor(String.class, String.class).newInstance(username, password));
		} catch (Exception e) {
			LOGGER.warn("Failed to instantiate {}", type);
			return Optional.empty();
		}
	}
}
