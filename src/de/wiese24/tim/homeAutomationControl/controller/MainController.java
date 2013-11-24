package de.wiese24.tim.homeAutomationControl.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.sensors.Sensor;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;

public class MainController {
	private List<Sensor> sensors = new LinkedList<Sensor>();
	private List<ActorController> controllers = new LinkedList<ActorController>();

	public void addController(ActorController controller) {
		this.controllers.add(controller);
	}

	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}

	public void update() {
		ArrayList<SensorState> sensorStates = new ArrayList<SensorState>();
		for (Sensor sensor : this.sensors) {
			SensorState state = sensor.getCurrentState();
			sensorStates.add(state);
		}
		for (ActorController actorController : this.controllers) {
			actorController.handleSensorStates(sensorStates);
		}
	}
}
