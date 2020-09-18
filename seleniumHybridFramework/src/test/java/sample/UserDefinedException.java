package sample;

import java.util.Scanner;

public class UserDefinedException {

	public static void main(String[] args) {
		
		int i, j, k;
		Scanner sc= new Scanner(System.in); 
		System.out.println("enter i: ");
		i=sc.nextInt();
		System.out.println("enter j: ");
		j=sc.nextInt();
		System.out.println(i + " " + j);
		
		//i=7;
		//j=9;
		//System.err.println(i);
	//1.
		/*
		try {
		k=i/j;
		System.out.println(k);
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println("end");
		}
		
		*/
		
	//2. user defined
		try {
		k=i/j;
		if(k==0) 
			throw new DivisionException("division is 0. Try again");
		
		}
		catch(DivisionException e) {
			System.out.println(e.getMessage());
		}
	}

}
