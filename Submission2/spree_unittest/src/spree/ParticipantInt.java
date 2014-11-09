package spree;


public interface ParticipantInt {
	String name = null;
	String id = null;
	String password = null;
	Admin admin = null;
	DashboardInt db = null;
	
	void doEventRegPar();
	Object logOut();
	

}

