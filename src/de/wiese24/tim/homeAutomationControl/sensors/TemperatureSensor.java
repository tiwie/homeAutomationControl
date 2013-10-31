package de.wiese24.tim.homeAutomationControl.sensors;

import de.wiese24.tim.homeAutomationControl.sensors.states.Temperature;

public class TemperatureSensor implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new Temperature(0);
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.TEMPERATURE;
	}

}
