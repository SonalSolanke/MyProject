package sample;

public abstract class B extends A implements I{
	
	int data=6;
	int k=17;
	
	public void display() {
		super.display();
		data=10;
		System.out.println(super.data);
		System.out.println("in B display");
	}
	
	public void show() {
		System.out.println("In B show");
	}

	public void getData() {
		System.out.println("From I ");
	}
	
	public abstract void abstractB();
	

	public void show(int i) {
		System.out.println("In B show- int i");
	}
	

	public void show(int i, String str) {
		System.out.println("In B show- int i String str");
	}
	
	
	
	
}
