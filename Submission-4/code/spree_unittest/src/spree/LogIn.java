package spree;


public class LogIn {

	public AdminInt ad1 = null;
	public ConvenorProfileFrameInt ad2 = null;
	public ParticipantProfileFrameInt ad3 = null;
	public EMProfileFrameInt ad4 = null;
	
	
	
	private Argument arg =  null;
	private Password pwd = null;
	
	
	public void setvalidateLogIn(AdminInt ad1) {
        this.ad1 = ad1;
    }

    public void setArgument(Argument arg) {
        this.arg = arg;
    }
    
    public void setPassword(Password pwd){
    	this.pwd = pwd;
    }
	
	public boolean validateLogIn() {
		if (ad1 == null) {
	        throw new RuntimeException("LogIn not yet maintained");
	    }
	 
	    return ad1.validateLogIn(arg, pwd);
	}
	
	public void checkUser(){
		if(arg == Argument.ORGANISERLOGIN){
			ad2.convenorLogIn();
		}
		else if( arg == Argument.PARTCIPANTLOGIN){
			ad3.participantLogIn();
		}
		else if ( arg == Argument.EMLOGIN){
			ad4.EMLogIn();
		}
		else {
			System.out.println("No user");
		}
	}

	
}
