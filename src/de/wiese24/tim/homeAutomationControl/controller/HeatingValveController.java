package de.wiese24.tim.homeAutomationControl.controller;

import java.util.List;

import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;

public class HeatingValveController extends ActorController {

	@Override
	public void handleSensorStates(List<SensorState> states) {
		int temperature = ((Integer) this.getSensorValue(states,
				SensorType.TEMPERATURE)).intValue();
		if (temperature <= 10) {
			System.out.println("switched heating on!");
		} else {
			System.out.println("switched heating off!");
		}

	}

}
