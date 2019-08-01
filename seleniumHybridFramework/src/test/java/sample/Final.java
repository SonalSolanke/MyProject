package sample;

public class Final {

	public static void main(String[] args) {
		//B obj= new B();
		B obj= new	c();
		System.out.println(obj.data);
		obj.display();
		obj.show();
		obj.getData();
		
		System.out.println("\t");
		obj.abstractB();
		
		System.out.println();
		
		System.out.print(" ");
		obj.nextData();
		
		System.out.println(obj.data);
		
		System.out.println("K is  "+ obj.k);
		
		//A obj1= new B();
	
		A obj1= new c();
		obj1.setEmpid(100);
		//obj1.data=60;
		
		System.out.println("data from A: " + obj1.data);
		int id= obj1.getEmpid();
		System.out.println("Emp id: "+  id);
		
		obj1.setEmpName("RR");
		String name= obj1.getEmpName();
		System.out.println("Emp Name is : "+name);

		obj1.display();
		
		A obj2=  new A();
		obj2.display();
		
		
		
		
		
	}

}
