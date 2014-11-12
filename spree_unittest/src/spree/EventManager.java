package spree;

public class EventManager implements EventManagerInt {

	String name=null;
	Game game=null;
	EventManager eh;
	InventoryInt i;
	SubmitResultFrameInt s;
	SendMessageFrameInt s1;
	SchedulingInt s2;
	SubmitScheduleFrameInt s3;
	DashboardFrameInt d;
	ViewResultsFrameInt v;
	
	
	public void setSendMessageFrame(SendMessageFrameInt a){
		this.s1=a;
		
	}
	public void viewInventoryRequest(){
		
	}
	public boolean setResult(){
		return false;
		
	}
	public void getMessage(){
		
	}
	public boolean sendMessage(){
		return s1.sendMessage();
		
	}
	public void viewDetails(){
		v.viewResults();
		s2.getSchedule();
		
	}
	
}
