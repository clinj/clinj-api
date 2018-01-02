package de.jmens.clinj.phone;

import static io.vavr.control.Try.of;

import io.vavr.control.Try;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ClinjPhone extends AutoCloseable {

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

	static Try<ClinjPhone> getPhone(String username, String password) {
		return getPhone(username, password, "de.jmens.clinj.phone.ClinjPhoneImpl");
	}

	static Try<ClinjPhone> getPhone(String username, String password, String type) {
		return Try.of(() -> {
			final Class<? extends ClinjPhone> clazz = (Class<? extends ClinjPhone>) Class.forName(type);
			return clazz.getConstructor(String.class, String.class).newInstance(username, password);
		});
	}
}
