package de.wiese24.tim.homeAutomationControl.actors;

import de.wiese24.tim.homeAutomationControl.actors.actions.ActorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.OnOffAction;

public class HeatingValveActor implements Actor {

	@Override
	public void execute(ActorAction action) {
		if (action instanceof OnOffAction) {
			Boolean on = (Boolean) action.getActionValue();
			//print in which status the heating is
			System.out.println("Switch heating "
					+ (on.booleanValue() ? " on!" : " off"));
		}
	}
}
