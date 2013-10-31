package de.wiese24.tim.homeAutomationControl.sensors;

import de.wiese24.tim.homeAutomationControl.sensors.states.WindSpeed;

public class WindSensor implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new WindSpeed(0);
	}
}
