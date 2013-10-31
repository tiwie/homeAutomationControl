package de.wiese24.tim.homeAutomationControl.sensers;

import java.util.Date;

import de.wiese24.tim.homeAutomationControl.sensors.states.Time;

public class Clock implements Sensor {

	@Override
	public SensorState getCurrentState() {
		return new Time(new Date());
	}
}
