package spree;


public class Participant {
	public ParticipantInt p1 = null;
	public UpdateProfileFrameInt p2 = null;
	public DashboardInt p3 = null;
	public EventRegInt p4 = null;
	
	public void displayDash(){
		
	}
	public void doEventRegPar(){
		
	}
	
	public void updateProfile(){
		
	}
	
	public Object logOut(){
		if (p1 == null) {
	        throw new RuntimeException("Participant not yet maintained");
	    }
		return(p1.logOut());
	}
}
