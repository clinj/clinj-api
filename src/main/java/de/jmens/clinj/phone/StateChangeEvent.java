package de.jmens.clinj.phone;

public class StateChangeEvent {

	private final PhoneState oldState;
	private final PhoneState currentState;

	public StateChangeEvent(PhoneState oldState, PhoneState currentState) {
		this.oldState = oldState;
		this.currentState = currentState;
	}

	public PhoneState getOldState() {
		return oldState;
	}

	public PhoneState getCurrentState() {
		return currentState;
	}
}
