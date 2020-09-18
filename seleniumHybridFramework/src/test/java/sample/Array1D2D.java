package sample;

class Calc{
	
	public static int add(int ... n)
	{
		int sum=0;
		for(int i:n)
		{
			sum=sum+i;
		}
		return sum;
	}

}



public class Array1D2D {

	public static void main(String[] args) {
		
		
		Calc obj= new Calc();
		System.out.println(obj.add(1,2,3,3,15,1));
		//int a[] = new int[4];
		
		int a[]= {1,2,3};
		
		int b[][] = {
						{1,2,3},
						{4,5,6},
						{2,5,9}				
		            };		
	
		for(int k:a)
		{
			System.out.print(k+ " ");
		}
		
		System.out.println();
		
		for(int p[]:b)   //p has {1,2,3},- whole 1st line of array
		{
			for(int q: p)  //q has 1 - 1st ele of array
			{
				
				System.out.print(q + "  ");
			}
			System.out.println();
			
		}
		
	}
	
	
	
	
	
}
