package spree;

public class Convenor implements ConvenorInt {

	
	public AccData accdata=null;
	 public void viewDepartmentDetails(String DeptName){
		 accdata.viewDepartmentDetails();
		 
	 }
	 
	 
	 public void setAccData(AccData a){
		 this.accdata=a;
		 
	 }
	public int viewFinances(){
		 return accdata.viewFinances();
	 }
}
