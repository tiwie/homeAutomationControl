package de.wiese24.tim.homeAutomationControl.actors.actions;

public class OnOffAction implements ActorAction {

	private Boolean on;

	public OnOffAction(Boolean on) {
		this.on = on;
	}

	@Override
	public Object getActionValue() {
		return this.on;
	}

}
