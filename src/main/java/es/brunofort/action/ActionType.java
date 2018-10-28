package es.brunofort.action;

public enum ActionType{

	RIGHT(new ActionGoToRight()), 
	LEFT(new ActionGoToLeft()), 
	TOP(new ActionGoToTop()), 
	DOWN(new ActionGoToDown());
	
	private Action action;

	private ActionType(Action action) {
		this.action = action;
	}

	public Action getAction() {
		return action;
	}
	
}
