package de.wiese24.tim.homeAutomationControl.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.actors.Actor;
import de.wiese24.tim.homeAutomationControl.actors.actions.ActorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorActionValue;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.SensorType;

public class BlindMotorController extends ActorController {

	private BlindMotorActionValue currentState = BlindMotorActionValue.OPEN;

	@Override
	public void handleSensorStates(List<SensorState> states) {
		// create new Action
		ActorAction action = createAction(states);
		for (Actor actor : this.actors) {
			actor.execute(action);
		}
	}

	private ActorAction createAction(List<SensorState> states) {

		/*
		 * CLOSE: Time.nacht; Wind >= 20; TEMP >= 30 DIM_ON: TEMP BETWEEN 20 and
		 * 25 OPEN: Time.tag ; Wind< 20; TEMP < 20
		 */

		switch (this.currentState) {
		case OPEN:
			if (checkClose(states)) {
				this.currentState = BlindMotorActionValue.CLOSE;
			} else if (checkDim(states)) {
				this.currentState = BlindMotorActionValue.DIM;
			}
			break;
		case DIM:
			if (checkClose(states)) {
				this.currentState = BlindMotorActionValue.CLOSE;
			} else if (checkOpen(states)) {
				this.currentState = BlindMotorActionValue.OPEN;
			}
			break;
		case CLOSE:
			if (checkOpen(states)) {
				this.currentState = BlindMotorActionValue.OPEN;
			} else if (checkDim(states)) {
				this.currentState = BlindMotorActionValue.DIM;
			}
			break;
		default:
			break;

		}

		return new BlindMotorAction(this.currentState);

	}

	private boolean checkOpen(List<SensorState> states) {
		Date date = (Date) this.getSensorValue(states, SensorType.TIME);

		// only on day time check if there are other conditions met to open the
		// blinds!
		if (isDay(date)) {
			int windSpeed = ((Integer) this.getSensorValue(states,
					SensorType.WIND_SPEED)).intValue();
			if (windSpeed >= 20) {
				return false;
			}

			int temperature = ((Integer) this.getSensorValue(states,
					SensorType.TEMPERATURE)).intValue();
			if (temperature < 20) {
				return true;
			}
		}
		return false;
	}

	private boolean checkClose(List<SensorState> states) {
		// first check time
		Date date = (Date) this.getSensorValue(states, SensorType.TIME);

		if (!isDay(date)) {
			return true;
		}

		// second check WindSpeed
		int windSpeed = ((Integer) this.getSensorValue(states,
				SensorType.WIND_SPEED)).intValue();
		if (windSpeed >= 20) {
			return true;
		}

		// third check Temperature
		int temperature = ((Integer) this.getSensorValue(states,
				SensorType.TEMPERATURE)).intValue();
		if (temperature >= 30) {
			return true;
		}

		return false;
	}

	private boolean checkDim(List<SensorState> states) {

		// only check Temperature
		int temperature = ((Integer) this.getSensorValue(states,
				SensorType.TEMPERATURE)).intValue();
		if (temperature >= 20 && temperature < 30) {
			return true;
		}
		return false;
	}

	private boolean isDay(Date date) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		if (hourOfDay >= 6 && hourOfDay < 22) {
			return true;
		}
		return false;
	}
}
