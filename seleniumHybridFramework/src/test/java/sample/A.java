package sample;

public class A {
	
	
	public static int data=5;
	private int empid;
	private String EmpName;
	public static int sample=5;
	
	
	public void display() 
	
	{
		
		System.out.println("in A display");
	}

	public int getEmpid() {
		return empid;
	}

	protected void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return EmpName;
	}

	protected void setEmpName(String empName) {
		EmpName = empName;
	}
	
	
	
}
