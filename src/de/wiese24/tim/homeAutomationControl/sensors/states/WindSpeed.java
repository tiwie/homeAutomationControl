package de.wiese24.tim.homeAutomationControl.sensors.states;

import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;

public class WindSpeed implements SensorState {
	//ToDo: generate a windSpeed
	private int windSpeed;

	public WindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public Object getValue() {
		return this.windSpeed;
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.WIND_SPEED;
	}

}
