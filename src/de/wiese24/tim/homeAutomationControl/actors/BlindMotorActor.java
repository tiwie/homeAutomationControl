package de.wiese24.tim.homeAutomationControl.actors;

import de.wiese24.tim.homeAutomationControl.actors.actions.ActorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorAction;
import de.wiese24.tim.homeAutomationControl.actors.actions.BlindMotorActionValue;

public class BlindMotorActor implements Actor {

	@Override
	public void execute(ActorAction action) {
		if (action instanceof BlindMotorAction) {
			BlindMotorActionValue open = (BlindMotorActionValue) action.getActionValue();
			String executedAction = "";
			//define for which status which text printed
			switch (open){
			case CLOSE:
				executedAction = "closed";
				break;
			case OPEN:
				executedAction = "opened";
				break;
			case DIM:
				executedAction = "dimmed";
				break;
			}

			//Write in which mode the Blind is
			System.out.println("Switched Blind to mode " + executedAction);
		}


	}
}
