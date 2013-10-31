package de.wiese24.tim.homeAutomationControl.sensors.states;

import java.util.Date;

import de.wiese24.tim.homeAutomationControl.sensers.SensorState;

public class Time implements SensorState {


		private Date date;

		public Time(Date date) {
			this.date = date;
			
		}

		@Override
		public Object getValue() {
			return this.date;
		}
}
