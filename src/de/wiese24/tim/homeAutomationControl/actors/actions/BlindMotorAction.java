package de.wiese24.tim.homeAutomationControl.actors.actions;


public class BlindMotorAction implements ActorAction {

	private BlindMotorActionValue motorActionValue;

	public BlindMotorAction(BlindMotorActionValue value) {
		this.motorActionValue = value;
	}

	@Override
	public Object getActionValue() {
		return this.motorActionValue;
	}

}
