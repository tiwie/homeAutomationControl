package de.wiese24.tim.homeAutomationControl.controller;

import java.util.LinkedList;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.actors.Actor;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;

public abstract class ActorController {

	protected List<Actor> actors = new LinkedList<Actor>();

	public void addActor(Actor actor) {
		this.actors.add(actor);
	}

	public abstract void handleSensorStates(List<SensorState> states);

	protected Object getSensorValue(List<SensorState> states,
			SensorType sensorType) {
		for (SensorState state : states) {
			SensorType type = state.getSensorType();

			if (type == sensorType)
				return state.getValue();
		}
		return null;
	}

}
