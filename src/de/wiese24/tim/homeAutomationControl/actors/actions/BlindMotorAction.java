package de.wiese24.tim.homeAutomationControl.actors.actions;

import de.wiese24.tim.homeAutomationControl.actors.BlindMotorActionValues;

public class BlindMotorAction implements ActorAction {

	private BlindMotorActionValues motorActionValue;

	public BlindMotorAction(BlindMotorActionValues value) {
		this.motorActionValue = value;
	}

	@Override
	public Object getActionValue() {
		return this.motorActionValue;
	}

}
