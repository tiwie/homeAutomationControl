package de.wiese24.tim.homeAutomationControl.controller;

import java.util.LinkedList;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.sensors.SensorState;

public class MainController extends ActorController {

	private List<ActorController> controllers = new LinkedList<ActorController>();

	public void addController(ActorController controller) {
		this.controllers.add(controller);
	}

	@Override
	public void handleSensorStates(List<SensorState> states) {
		for (ActorController controller : this.controllers) {
			controller.handleSensorStates(states);
		}
	}
}
