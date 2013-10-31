package de.wiese24.tim.homeAutomationControl.controller;

import java.util.List;

import de.wiese24.tim.homeAutomationControl.actors.Actor;
import de.wiese24.tim.homeAutomationControl.actors.actions.ActorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorActionValue;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;
import de.wiese24.tim.homeAutomationControl.sensors.states.WindSpeed;

public class BlindMotorController extends ActorController {

	private WindSpeed oldWindSpeed;

	@Override
	public void handleSensorStates(List<SensorState> states) {
		ActorAction action = createAction(states);
		for (Actor actor : this.actors) {
			actor.execute(action);
		}
	}

	private ActorAction createAction(List<SensorState> states) {
		for (SensorState state : states) {
			SensorType type = state.getSensorType();
			switch (type) {
			case WIND_SPEED:
				int value = ((Integer) state.getValue()).intValue();
				if (value > 20) {
					return new BlindMotorAction(BlindMotorActionValue.CLOSE);
				}
				break;
			case TEMPERATURE:
				break;
			case TIME:
				break;
			default:
				break;
			}
		}
		return null;
	}
}
