package de.jmens.clinj.phone;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;

/**
 * Represents a phone device. A #ClinjPhone can initialte outbound calls to any remote party by sip URI or public phone number.
 * If registered, it can receive inbound calls from any remote party as well.
 * The {@link ClinjPhone} can handle multiple #Call instances simultaneous and gives access to all currently running calls.
 * Call related operations like hangup, transfer etc. are provided by the corresponding {@link Call} instances.
 */
public interface ClinjPhone extends AutoCloseable {

	Logger LOGGER = getLogger(ClinjPhone.class);

	CompletableFuture<Boolean> register();

	OutboundCall newCall(String callee);

	ClinjPhone addInboundListener(InboundCallListener inboundListener);

	Collection<Call> getCalls();

	Collection<OutboundCall> getOutboundCalls();

	Collection<InboundCall> getInboundCalls();

	CompletableFuture<Boolean> shutdown();

	/**
	 * Returns a specific inbound call.
	 *
	 * @param callId Id of the requested call.
	 * @return Running #InboundCall instance with the requested id or empty if this id is not known.
	 */
	default Optional<InboundCall> getInboundCall(String callId) {
		return getInboundCalls()
				.stream()
				.filter(call -> call.getCallId().equals(callId))
				.findFirst();
	}

	/**
	 * Returns a specific call object out of all running inbound and outbound calls.
	 *
	 * @param callId Id of the requested call.
	 * @return Running {@link Call} instance with the requested id or empty if this id is not known.
	 */
	default Optional<Call> getCall(String callId) {
		return getCalls()
				.stream()
				.filter(call -> call.getCallId().equals(callId))
				.findFirst();
	}

	/**
	 * Returns a specific outbound call.
	 *
	 * @param callId Id of the requested call.
	 * @return Running {@link OutboundCall} instance with the requested id or empty if this id is not known.
	 */
	default Optional<OutboundCall> getOutboundCall(String callId) {
		return getOutboundCalls()
				.stream()
				.filter(call -> call.getCallId().equals(callId))
				.findFirst();
	}

	/**
	 * Factory method to generate new #ClinjPhone implementations.
	 *
	 * @param username Username used to register the phone.
	 * @param password Password used to register the phone. This is a 7 digit number followed by an 'e' and some more digits. <code>1234567e1</code>, e.g.
	 * This is exactly the same id provided by {@link de.jmens.clinj.model.Phoneline} instances.
	 *
	 * @return A new #ClinjPhone implementation.
	 */
	static Optional<ClinjPhone> getPhone(String username, String password) {
		return getPhone(username, password, "de.jmens.clinj.phone.ClinjPhoneImpl");
	}

	/**
	 * Factory method to generate new #ClinjPhone implementations.
	 *
	 * @param username Username used to register the phone.
	 * @param password Password used to register the phone. This is a 7 digit number followed by an 'e' and some more digits. <code>1234567e1</code>, e.g.
	 * This is exactly the same id provided by {@link de.jmens.clinj.model.Phoneline} instances.
	 * @param type Specifies the type used to instantiate #ClinjPhone implentation.
	 *
	 * @return A new #ClinjPhone implementation.
	 */
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
