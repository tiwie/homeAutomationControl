package de.wiese24.tim.homeAutomationControl.sensors;

import de.wiese24.tim.homeAutomationControl.sensors.states.WindSpeed;

public class WindSensor implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new WindSpeed(WeatherConditions.WIND_SPEED);
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.WIND_SPEED;
	}
}
