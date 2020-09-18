package sample;

class P{
	
	public void show() {
		System.out.println("in A");
		
	}
	
}

class Q extends P{
	
	public void show() {
		System.out.println("in B");
		
	}
	
}


public class OOPS1 {

	public static void main(String[] args) {
		Q obj= new Q();
		obj.show();
		

	}

}
