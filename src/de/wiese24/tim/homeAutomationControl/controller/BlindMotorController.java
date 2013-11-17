package de.wiese24.tim.homeAutomationControl.controller;

import java.util.Date;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.actors.Actor;
import de.wiese24.tim.homeAutomationControl.actors.actions.ActorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorActionValue;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;
import de.wiese24.tim.homeAutomationControl.sensors.states.Temperature;
import de.wiese24.tim.homeAutomationControl.sensors.states.WindSpeed;

public class BlindMotorController extends ActorController {

	private WindSpeed oldWindSpeed;

	private Temperature oldTemperature;

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
			ActorAction windSpeedAction = null;
			ActorAction temperatureAction = null;
			ActorAction timeAction = null;
			switch (type) {
			case WIND_SPEED:
				int windSpeed = ((Integer) state.getValue()).intValue();
				if (windSpeed == ((Integer) oldWindSpeed.getValue()).intValue()) {
					break;
				}
				if (windSpeed > 20) {
					return new BlindMotorAction(BlindMotorActionValue.CLOSE);
				} else {
					windSpeedAction = new BlindMotorAction(
							BlindMotorActionValue.OPEN);
				}
				break;
			case TEMPERATURE:
				int temperature = ((Integer) state.getValue()).intValue();
				if (temperature == ((Integer) oldTemperature.getValue())
						.intValue()) {
					break;
				}
				if (temperature > 20) {
					temperatureAction = new BlindMotorAction(
							BlindMotorActionValue.CLOSE);
				} else if (temperature < 20 && temperature > 15) {
					temperatureAction = new BlindMotorAction(
							BlindMotorActionValue.DIM_OFF);
				} else {
					temperatureAction = new BlindMotorAction(
							BlindMotorActionValue.OPEN);
				}
				break;
			case TIME:
				Date date = (Date) state.getValue();
				// finde heraus, ob es nach 06:00 a.m. Uhr ist oder nach 6:00
				// p.m.
				break;
			default:
				break;
			}

		}
		return null;
	}
}
