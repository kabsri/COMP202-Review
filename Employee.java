//We want the id of each employee to be the order in which they were hired
//The first employee should have id=1, the second employee should have id=2, etc...

public class Employee {
	
	private static int numEmployees=0;
	private int id;
	private String name;
	private String jobTitle;
	private double hourlyWage;
	
	public Employee(String n, String jt, double hw){
		name = n;
		jobTitle = jt;
		hourlyWage = hw;
		numEmployees = numEmployees+1;
		id = numEmployees;
	}
	
	public String getInfo(){
		return name+": "+jobTitle;
	}
	
	public void setHourlyWage(double hw){
		hourlyWage = hw;
	}

}
