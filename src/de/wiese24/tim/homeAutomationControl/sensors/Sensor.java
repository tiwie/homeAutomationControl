package de.wiese24.tim.homeAutomationControl.sensors;

public interface Sensor {

	public SensorState getCurrentState();
	
	public SensorType getSensorType();
}
