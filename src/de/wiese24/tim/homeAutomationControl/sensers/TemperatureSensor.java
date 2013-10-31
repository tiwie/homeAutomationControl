package de.wiese24.tim.homeAutomationControl.sensers;

import de.wiese24.tim.homeAutomationControl.sensors.states.Temperature;

public class TemperatureSensor implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new Temperature(0);
	}

}
