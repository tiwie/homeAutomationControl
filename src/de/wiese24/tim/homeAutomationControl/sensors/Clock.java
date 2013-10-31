package de.wiese24.tim.homeAutomationControl.sensors;

import java.util.Date;

import de.wiese24.tim.homeAutomationControl.sensors.states.Time;

public class Clock implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new Time(new Date());
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.TIME;
	}
}
