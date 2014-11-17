package spree;


public class Admin1 {
	
	public LogInInt ai1 = null;
	public AccDataInt ai2 = null;
	
	private Argument arg =  null;
	private Password pwd = null;
	
	public void setvalidateLogIn(LogInInt ai1) {
        this.ai1 = ai1;
    }

    public void setArgument(Argument arg) {
        this.arg = arg;
    }
    
    public void setPassword(Password pwd){
    	this.pwd = pwd;
    }
	
	public boolean validateLogIn() {
		if (ai1 == null) {
	        throw new RuntimeException("LogIn not yet maintained");
	    }
	   /* if (arg == null) {
	        throw new RuntimeException("argument not yet maintained");
	    }
	    if (pwd == null) {
	        throw new RuntimeException("password not yet maintained");
	    }*/
	    return ai1.validateLogIn(arg, pwd);
	}
	
	public void addData(){
		
	}
	public void viewData(){
		
	};
	public void modifyData(){
		
	};
	public void validateData(){
		
	};
	
	
	
	
}
