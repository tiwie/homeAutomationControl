package de.wiese24.tim.homeAutomationControl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.wiese24.tim.homeAutomationControl.actors.BlindMotorActor;
import de.wiese24.tim.homeAutomationControl.actors.HeatingValveActor;
import de.wiese24.tim.homeAutomationControl.controller.BlindMotorController;
import de.wiese24.tim.homeAutomationControl.controller.HeatingValveController;
import de.wiese24.tim.homeAutomationControl.controller.MainController;
import de.wiese24.tim.homeAutomationControl.sensors.Clock;
import de.wiese24.tim.homeAutomationControl.sensors.Sensor;
import de.wiese24.tim.homeAutomationControl.sensors.SensorState;
import de.wiese24.tim.homeAutomationControl.sensors.TemperatureSensor;
import de.wiese24.tim.homeAutomationControl.sensors.WeatherConditions;
import de.wiese24.tim.homeAutomationControl.sensors.WindSensor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MainController mainController = new MainController();
		BlindMotorController blindMotorController = new BlindMotorController();
		BlindMotorActor blind1 = new BlindMotorActor();
		BlindMotorActor blind2 = new BlindMotorActor();
		blindMotorController.addActor(blind1);
		blindMotorController.addActor(blind2);
		mainController.addController(blindMotorController);

		HeatingValveController heatingValveController = new HeatingValveController();
		HeatingValveActor valve1 = new HeatingValveActor();
		HeatingValveActor valve2 = new HeatingValveActor();
		heatingValveController.addActor(valve1);
		heatingValveController.addActor(valve2);
		mainController.addController(heatingValveController);

		// create sensors
		List<Sensor> sensors = getSensors();

		WeatherConditions.TEMPERATURE = 9;
		WeatherConditions.WIND_SPEED = 19;
		Clock.NOW = new Date();

		mainController.handleSensorStates(getCurrentStates(sensors));

		WeatherConditions.TEMPERATURE = 10;
		WeatherConditions.WIND_SPEED = 19;
		Clock.NOW = new Date();

		mainController.handleSensorStates(getCurrentStates(sensors));

		WeatherConditions.TEMPERATURE = 20;
		WeatherConditions.WIND_SPEED = 19;
		Clock.NOW = new Date();

		mainController.handleSensorStates(getCurrentStates(sensors));

	}

	private static List<Sensor> getSensors() {
		final Sensor clock = new Clock();
		final Sensor windSensor = new WindSensor();
		final Sensor temperatureSensor = new TemperatureSensor();
		final List<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(clock);
		sensors.add(windSensor);
		sensors.add(temperatureSensor);
		return sensors;
	}

	private static List<SensorState> getCurrentStates(List<Sensor> sensors) {
		List<SensorState> sensorStates = new ArrayList<SensorState>();
		for (Sensor sensor : sensors) {
			sensorStates.add(sensor.getCurrentState());
		}
		return sensorStates;
	}

}
