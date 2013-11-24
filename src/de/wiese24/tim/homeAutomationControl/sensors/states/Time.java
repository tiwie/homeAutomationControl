package de.wiese24.tim.homeAutomationControl.sensors.states;

import java.util.Date;

import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;

public class Time implements SensorState {
	//ToDo: define the Time in a class named Time
	private Date date;

	public Time(Date date) {
		this.date = date;

	}

	@Override
	public Object getValue() {
		return this.date;
	}

	@Override
	public SensorType getSensorType() {
		return SensorType.TIME;
	}
}
