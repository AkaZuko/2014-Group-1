package spree;

public class EventsHead implements EventsHeadInt {

	
	String name=null;
	InventoryInt i=null;
	ViewResultsFrameInt v=null;
	SendMessageFrameInt s=null;

	
	public void setInventory(InventoryInt i){
		this.i=i;
		
	}
	public int approveInventoryRequest(){
		return i.pushItem();
		
		
	}
	
	public void viewLog(){
		
	}

}
