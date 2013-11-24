package de.wiese24.tim.homeAutomationControl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import de.wiese24.tim.homeAutomationControl.actors.BlindMotorActor;
import de.wiese24.tim.homeAutomationControl.actors.HeatingValveActor;
import de.wiese24.tim.homeAutomationControl.controller.BlindMotorController;
import de.wiese24.tim.homeAutomationControl.controller.HeatingValveController;
import de.wiese24.tim.homeAutomationControl.controller.MainController;
import de.wiese24.tim.homeAutomationControl.sensors.Clock;
import de.wiese24.tim.homeAutomationControl.sensors.Sensor;
import de.wiese24.tim.homeAutomationControl.sensors.TemperatureSensor;
import de.wiese24.tim.homeAutomationControl.sensors.WeatherConditions;
import de.wiese24.tim.homeAutomationControl.sensors.WindSensor;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		MainController mainController = new MainController();

		createActors(mainController);

		createSensors(mainController);

		runWith(mainController, 9, 3, 7, 30, "opended", "on");
		Thread.sleep(5000);

		runWith(mainController, 15, 6, 9, 0, "opened", "off");
		Thread.sleep(5000);

		runWith(mainController, 23, 12, 12, 0, "dimmed", "off");
		Thread.sleep(5000);

		runWith(mainController, 28, 15, 14, 30, "dimmed", "off");
		Thread.sleep(5000);

		runWith(mainController, 19, 2, 18, 30, "opened", "off");
		Thread.sleep(5000);
	}

	private static void runWith(MainController mainController, int temperature,
			int windspeed, int hours, int minutes, String blindState,
			String heatingState) {
		WeatherConditions.TEMPERATURE = temperature;
		WeatherConditions.WIND_SPEED = windspeed;
		Clock.NOW = createDate(hours, minutes);
		System.out.println("It is " + hours + ":" + minutes
				+ ".  Windspeed is " + windspeed + ", temperature is "
				+ temperature + " °C ==> we expect Blinds are " + blindState
				+ ", Heating is " + heatingState);
		mainController.update();
	}

	private static void createActors(MainController mainController) {

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
	}

	private static void createSensors(MainController controller) {
		final Sensor clock = new Clock();
		final Sensor windSensor = new WindSensor();
		final Sensor temperatureSensor = new TemperatureSensor();
		controller.addSensor(clock);
		controller.addSensor(windSensor);
		controller.addSensor(temperatureSensor);
	}

	private static Date createDate(int hours, int minutes) {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

}
