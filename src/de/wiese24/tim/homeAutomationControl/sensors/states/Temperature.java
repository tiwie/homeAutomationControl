package de.wiese24.tim.homeAutomationControl.sensors.states;

import de.wiese24.tim.homeAutomationControl.sensers.SensorState;

public class  Temperature implements SensorState {

	private int temperature;

	public Temperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public Object getValue() {
		return this.temperature;
	}

}

