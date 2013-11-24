package de.wiese24.tim.homeAutomationControl.sensors;

import de.wiese24.tim.homeAutomationControl.sensors.states.Temperature;

public class TemperatureSensor implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new Temperature(WeatherConditions.TEMPERATURE);
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.TEMPERATURE;
	}

}
