package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AAIMPJavaCodingQ {

	public static void main(String[] args) throws IOException {
		
	//1. How to reverse a string without using existing functions/ stringBuffer/StringBuilder

		String str= "sonalsolanke";
		String rev= "";
		for(int i=str.length()-1; i>=0; i--)
		{
			rev= rev+ str.charAt(i);
		}
		System.out.println("Reverse of string-  "+ str +  "is:  " +rev);
	
	
	//2. How to reverse a string using existing functions/ stringBuffer/StringBuilder

		StringBuffer s= new StringBuffer(str);
		System.out.println("Rev with StringBuffer:  " + s.reverse());
		
		StringBuilder sb= new StringBuilder(str);
		System.out.println("Rev with StringBuilder:  " + sb.reverse());
		
		
	//3. Remove junk / special characters from a string
		
		String junkCharStr= "^sona*l$y12_";
		  
		String withoutJunkStr= junkCharStr.replaceAll("[^a-zA-Z0-9]", "");
		
		System.out.println("Without junk chars:  " + withoutJunkStr);
		
	//4. Reverse a number
		
		int oriNum=12345;
		int revNum=0;
		
		while(oriNum!=0)
		{
			revNum= revNum*10 + oriNum%10 ;  //5
			oriNum= oriNum/10;				//1234
						
		}
		
		
		System.out.println("Reverse number is : " + revNum);
		
	//5. Reverse integer with StringBuffer or Builder class
		
		int num1=123456;
		StringBuffer stb= new StringBuffer(String.valueOf(num1));
		System.out.println("Reverse is:  "+ stb.reverse());
		
		
	//6. Find missing element in an array- when array is in sequence
		
		int arr[]= {1,2,3,4,6,7,8};  // 5 is missing  // login:  missing ele= (sum of all elements in start to end range  -  sum of element in array)
		int length= arr.length;
		int sumArr=0;
		int sumRange= 0;
		int missingNum;
		for(int i=0; i<=length-1; i++)
		{
			sumArr= sumArr+ arr[i];
			
		}		
		System.out.println("sum of arr elements= " + sumArr);
		
		int arrMin=arr[0];
		int arrMax= arr[length-1];
		
		for(int i=arrMin; i<=arrMax; i++)
		{
			sumRange= sumRange+ i;
			
		}
		System.out.println("sum of elements in min max range= " + sumRange);
		
		missingNum=  sumRange- sumArr;
		System.out.println("Missing nium in array is : "+missingNum);
		
		
	//7. Find duplicate number in array
		
		int a[]= {2,4,5,6,2,5,8,9};  // dup - 2 and 5
		
		for(int i=0; i<a.length; i++)
		{
			
			for(int j=i+1; j<a.length; j++)
			{
				if(a[i]==a[j])
					System.out.println("Duplicate num is: "+ a[i]);
				
			}
			
		}
		
	//8. Find duplicate element in array- string array
		
		String st[]= {"Ruby", "Java", "Ruby", "c#", "Selenium", "Java"};
		
		for(int i=0; i<st.length; i++)
		{
			
			for(int j=i+1; j<st.length; j++)
			{
				if(st[i].equalsIgnoreCase(st[j]))
					System.out.println("Duplicate num is: "+ st[i]);
				
			}
			
		}
		
	//9. Smallest and largest numbers in array
		
		int ar[]= {1,4,7,2,-3,9};
		int smallestNum=ar[0], largestNum=ar[0];
		
		for(int i=0; i<ar.length; i++)
		{
			if(ar[i] > largestNum)
				largestNum= ar[i];
			else if(ar[i] < smallestNum)
				smallestNum= ar[i];
		}
		
		System.out.println("largestNum is : " + largestNum);
		System.out.println("smallestNum is : " + smallestNum);
		
		
	//10. Swap two numbers- with temp variable
		
		int n1=123;
		int n2= 456;
		int temp=0;
		
		temp=n1;
		n1=n2;
		n2=temp;
		
		System.out.println("swapped nos: " +n1 +  "  " + n2);
		
	//10. Swap two numbers- without temp variable	
		
		int x=123;
		int y= 456;
			
		x= x+y;       //imp:  x y x
		y= x-y;   
		x= x-y;
		
		System.out.println("swapped nos: " +x +  "  " + y);
		
	//11. Swap two springs without third variable
		String first= "Hellow";
		String second= "Sonal";
		
		first= first+second;   //imp: first, second, first
		
		second= first.substring(0, first.length() - second.length());  // second= Hellow
		
		first= first.substring(second.length());  // first= Sonal
		
		System.out.println("Swapped:first  " + first + "  swapped: second  " + second  );
		
	
	//12. Check if string is a palindrome
		
		String oriStr= "Madam";
		String revStr= "";
		
		for(int i=oriStr.length() -1 ; i>=0; i--)
		{
			revStr= revStr + oriStr.charAt(i);
			
		}
		
		if(oriStr.equalsIgnoreCase(revStr))
			System.out.println("Its a Palindrome");
		else
			System.out.println("Not a Palindrome");
		
		
		
	//13. Verify if the string contains only digits	
		System.out.println(isStringNumeric1("@@@@"));
		System.out.println(isStringNumeric1("56576677"));
		System.out.println(isStringNumeric1("56A576677"));
		System.out.println(isStringNumeric1("565@@76677"));
		System.out.println(isStringNumeric1("   56576677"));
		
		System.out.println(isStringNumeric1("565766  !77"));
		System.out.println(isStringNumeric1(""));
		System.out.println(isStringNumeric1(" "));
		System.out.println(isStringNumeric1("null"));
	
		System.out.println("other way");
		
		System.out.println(isStringNumeric2("@@@@"));
		System.out.println(isStringNumeric2("56576677"));
		System.out.println(isStringNumeric2("56A576677"));
		System.out.println(isStringNumeric2("565@@76677"));
		System.out.println(isStringNumeric2("   56576677"));
		
		System.out.println(isStringNumeric2("565766  !77"));
		System.out.println(isStringNumeric2(""));
		System.out.println(isStringNumeric2(" "));
		System.out.println(isStringNumeric2("null"));
		
		
	//14. Find sum of digits in a number
		
		int myNum=123451;
		int sum=0;
		
		while(myNum!=0)
		{
		sum=sum + myNum %10 ; //5 
		myNum= myNum/10;  //1234
		}
		System.out.println("sum of all digits:  "+ sum);
		
		
	//15. Move all Negative elements to end of the array
		
		int allArr[]= {1, 5,-3, 6,-8, 34, 0, -9, 7};
		
		List<Integer> allArrayEle= new ArrayList<>();
		List<Integer> allNegativeEle= new ArrayList<>();
		
		for(Integer array:allArr)
		{
			if(array >=0)
				allArrayEle.add(array);
			else
				allNegativeEle.add(array);			
			
		}
		
		allArrayEle.addAll(allNegativeEle);
		System.out.println("new array with negative elements at end:  " + allArrayEle);
		
	//16. Move all Negative elements to end of the array
		

		int allArr1[]= {0, 0,-3, 6,-8, 34, 0, -9, 7};
		
		List<Integer> allArrayEle1= new ArrayList<>();
		List<Integer> allZeroEle= new ArrayList<>();
		
		for(Integer array1:allArr1)
		{
			if(array1 == 0)
				allZeroEle.add(array1);
			
			else
				allArrayEle1.add(array1);			
			
		}
		
		allArrayEle1.addAll(allZeroEle);
		System.out.println("new array with zero elements at end:  " + allArrayEle1);
			 			 
		 
	//17. Print all Even and odd numbers in given range
		
		int number1=1;
		int number2=10;
		
		List<Integer> evenNums= new ArrayList<>();
		List<Integer> oddNums= new ArrayList<>();
		
		for(int i=number1; i<=number2; i++)
		{
			if(i % 2 == 0)
				evenNums.add(i);
				//System.out.println(i+ "is Even num ");
			else
				oddNums.add(i);				
				//System.out.println(i+ "is Odd num ");
			
		}
		
		System.out.println("Even numbers: " + evenNums);
		System.out.println("Odd numbers: " + oddNums);
		
		
		
	//18: Count Number of occurences of specific character in given string
		
		String str1;
		System.out.println("Enter String : ");  //AASAASSW
		Scanner sc= new Scanner(System.in);
		str1= sc.next();
		
		System.out.println("Enter Character : ");  //A
		char ch= (char)System.in.read();
		
		int numOdOccurences=0;
		for(int i=0; i<str1.length(); i++)
		{
			if(str1.charAt(i)==ch)
				numOdOccurences++;
			
		}
		System.out.println("numOdOccurences of : "+ ch + " is:  "+numOdOccurences);    //A is 4
		
	//19. Armstrrong number:  153- 1*1*1 + 5*5*5 + 3*3*3 = 1+ 125 + 27 = 153
		
		//Scanner sc1= new Scanner(System.in);
		//System.out.println("Enter a number to check if it is Armstrong number: ");
		
		
		//int numb= sc1.nextInt();
		
		int numb=153;  //if scanner not used
		int oriNumb= numb;
		int r, summ=0;
		
		while(numb!= 0)
		{
			r=numb % 10;   //3
			numb= numb / 10;  //15
			
			summ= summ + r*r*r ;			
			
		}
		
		if(summ==oriNumb)
			System.out.println(oriNumb + " is Armstrong number");
		else
			System.out.println(oriNumb + " is not A rmstrong number");
		
	
	//20. Prime number - number divisible by 1 or itself- 
		
		int numChk= 41;
		boolean isPrime= true;
		
		for(int i=2; i<numChk / 2; i++)
		{
			if(numChk % i == 0)
			{
				isPrime= false;
				
				break;
			}	
			
		}
		
		
		if(isPrime)
			System.out.println(numChk + " is prime");
		else
			System.out.println(numChk + " is not prime");
		

	//21. Fibonacci series  1 1 2 3 5 8 13.....
		
		int fNum=10; // we can get this number thr scanner too
		int p=0, q=1, k=0;
		
		//way 1:-  when max no of digits to be displayed is given  //0 1 1 2 3 5 8 13 21 34 
		int maxfNum=10;
		int p1=0, q1=1;
		for(int i=1; i<= maxfNum ; i++)
		{
			System.out.print(p1+ " ");
			k=p1+q1;
			p1=q1;
			q1=k;
			
		}
		
		
		System.out.println();
		//way 2  - when fibb num to be diaplayed is given    //0 1 1 2 3 5 8 13
		System.out.print(p + " " +q) ;
		int k1=0;
		while(k1 <= fNum)
		{
			k1=p+q;
			System.out.print(" " +k1);
			
			p=q;
			q=k1;
				
		}
		
		System.out.println();
		
	//22. Hashmap ex:  print number of occurences of each word in java i gven string
		
		
		String strTest= "I am am Java Java Java";
		
		String strT[]= strTest.split(" ");

		Map<String, Integer> m= new HashMap<>();
		for(String tempString: strT)
		{
			// put in hashmap
			if(m.get(tempString) != null)
				m.put(tempString, m.get(tempString)+1);
			else
				m.put(tempString, 1);
		}
		System.out.println(m);   // prints all words with num of occurences-    {Java=3, I=1, am=2}
		
		
		// to print only duplicate words with no of occurences
		Iterator<String> it= m.keySet().iterator();
		
		while(it.hasNext())
		{
			String temp1= it.next();
			
			if(m.get(temp1) > 1)
				
				System.out.println("word " + temp1 + " occured " + m.get(temp1) + " times");
				
		}
		
		//o/p  :   word Java occured 3 times
				// word am occured 2 times
		
		
	//23. Find character occurences in a string using hashmap
		
		String str2= "AASHWREAR";
		Map<Character, Integer> hm= new HashMap<>();
		
		for(int i=0; i<str2.length(); i++)
		{
			if(hm.get(str2.charAt(i)) != null)
			{
				hm.put(str2.charAt(i), hm.get(str2.charAt(i))+1);
			}
			else
				hm.put(str2.charAt(i), 1);
						
		}
		
		System.out.println(hm);   //{A=3, R=2, S=1, E=1, W=1, H=1}
		
		
	//24. How to read data from text file
		
		//Approach 1:  using FileReader and BufferedReader classes
		
		FileReader fr= new FileReader("F:\\JavaTest.txt");
		
		BufferedReader br= new BufferedReader(fr);    // fr to be passes to BufferedReader obj
		
		String line;
		
		while(( line= br.readLine() ) != null)  // if we know how many lines are there- we can go for for loop
		{
			System.out.println(line);
						
		}
		
		br.close();
		
		
		//Approach 2:  using File ans scanner 
		
		File file= new File("F:\\\\JavaTest.txt");
		
		Scanner sc1= new Scanner(file);
		
		while(sc1.hasNextLine())
		{
			System.out.println(sc1.nextLine());
			
		}
		
		
		//Approach 3:  using scanner useDelimiter method
		File file1= new File("F:\\\\JavaTest.txt");
		
		Scanner sc2= new Scanner(file);
		
		sc2.useDelimiter("\\Z");
		System.out.println(sc2.next());
		
		
		
	//25.  read num of line, num of words and num of characters from a text file
		
		int numLines=0, numWords=0, numChars=0;
		File file2= new File("F:\\JavaTest.txt");
		
		Scanner sc3= new Scanner(file);
		
		while(sc3.hasNextLine())
		{
			boolean foundDiv= true;
			boolean foundChar=false;
			
			String currentLine= sc3.nextLine();
			
			for(int i=0; i< currentLine.length() ; i++)
			{
				
				if(currentLine.charAt(i) == ' ')
				{
					 foundDiv= true;
					 foundChar=false;
				}
				else
				{
					foundChar=true;
					numChars++;
					
				}
				
				if(foundDiv && foundChar)
				{
					numWords++;
					foundDiv=false;  // no division since last caracter
					
				}
				
			}
			numLines++;
					
			
		}
		System.out.println("numLines  " +numLines);
		System.out.println("numWords  " +numWords);
		System.out.println("numChars  " +numChars);
		
		
		
 //26. Write to text file
		
		FileOutputStream fos= new FileOutputStream("F:\\JavaWrite.txt");
		
		PrintWriter pw= new PrintWriter(fos);
		
		pw.println("My file");
		pw.println("sonal");
		
		pw.close();
	} 
	
	//13. Verify if the string contains only digits	- function
	public static boolean isStringNumeric1(String str)
	{
		String str1= str.replaceAll("[^0-9]", "");
		
		if(str1== "" || str1==null)
			return false;
		else if(str1.equals(str))
			return true;
		else
		    return false;
		
	}
	
	public static boolean isStringNumeric2(String str)
	{
		if(str.isEmpty())
			return false;
		
		for(int i=0; i<str.length(); i++)
		{
			if(! Character.isDigit(str.charAt(i)))
				return false;
			
		}
		return true;
		
		
		
	}
	
}
