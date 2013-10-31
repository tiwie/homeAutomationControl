package de.wiese24.tim.homeAutomationControl.controller;

import java.util.LinkedList;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.actors.Actor;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;

public abstract class ActorController {

	protected List<Actor> actors = new LinkedList<Actor>();
	
	public void addActor(Actor actor)
	{
		this.actors.add(actor);
	}
	
	public abstract void handleSensorState(List<SensorState> states);
}
