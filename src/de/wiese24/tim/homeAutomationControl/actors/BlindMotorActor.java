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
			switch (open){
			case CLOSE:
				executedAction = "closed";
				break;
			case OPEN:
				executedAction = "opened";
				break;
			case DIM_OFF:
				executedAction = "dimmed off";
				break;
			case DIM_ON:
				executedAction = "dimmed";
				break;
			}

			System.out.println("Switched Blind to mode " + executedAction);
		}


	}
}
