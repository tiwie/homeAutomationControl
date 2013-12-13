package de.wiese24.tim.homeAutomationControl.sensors.states;

import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;

public class Temperature implements SensorState {
	private int temperature;

	public Temperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public Object getValue() {
		return this.temperature;
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.TEMPERATURE;
	}

}
