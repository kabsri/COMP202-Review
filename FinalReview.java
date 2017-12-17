import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FinalReview{

	public static void main(String[] args){
		
		int[][] arr = {{1,4,4}, {9,2}, null, {5,1,7,6}};
		exception3();
		
	}
	
	/*///////////////////////////////
	 * MULTI-DIMENSIONAL ARRAYS
	 *///////////////////////////////
	
	//isRectangular takes a 2D array of doubles and checks whether the array is rectangular
	public static boolean isRectangular(double[][] arr){
		if (arr == null){
			return false;
		}
		for (int i=0; i<arr.length; i++){
			if (arr[i].length != arr[0].length){
				return false;
			}
		}
		return true;
	}
	
	//multipliable() takes two 2D arrays and checks if they are "multipliable" 
	//Multipliable means both arrays are rectangular and the number of columns in a is the number of rows in b
	public static boolean multipliable(double[][] a, double[][] b){
		if (isRectangular(a) && isRectangular(b)){
			return a[0].length == b.length;
		}
		return false;
	}
	
	//multiply takes two 2D arrays, checks if they are multipliable and then does a matrix multiplication
	//If you don't know any linear algebra don't worry about this method
	public static double[][] multiply(double[][] a, double[][] b){
		if (multipliable(a,b)){
			double[][] ab = new double[a.length][b[0].length];
			for (int i=0; i<ab.length; i++){
				for (int j=0; j<ab[i].length; j++){
					for (int k=0; k<a[0].length; k++){
						ab[i][j] += a[i][k]*b[k][j];
					}
				}
			}
			return ab;
		}
		return null;
	}
	
	//What are the values of arr by the end of this method?
	public static void arrays1(){
		int[][] arr = new int[3][];
		int[] a = {1, 3};
		arr[0] = a;
		arr[1] = new int[5];
		arr[2] = arr[1];
		arr[1][2] = 1;
	}
	
	
	public static void arrays2(){
		
	}
	
	/*///////////////////////
	 * EXCEPTION HANDLING
	 *///////////////////////
	
	//This method throws a new IllegalArgumentException
	//When we call this method we must make sure to be careful with Exceptions
	private static String errorCode(int n){
		if (n==0)
			return "Zero";
		else if (n>0)
			return "Not zero";
		else
			throw new IllegalArgumentException("Negative number");
	}
	
	//Here we call errorCode() with a try-catch block to take care of the exception
	public static void handler1(int n){
		try{
			System.out.println(errorCode(n));
		} catch (IllegalArgumentException e){
			System.out.println("Can't deal with negative numbers");
		}
	}
	
	//Here we call errorCode() and if an error gets thrown, we propagate the error to where we called handler2()
	public static void handler2(int n) throws IllegalArgumentException{
		System.out.println(errorCode(n));
	}
	
	//What does this method output? Figure it out first then call it and see what happens
	public static int exception1(){
		int[] abc = new int[10];
		int a=0;
		for (int i=0; i<=10; i++){
			if (i>0){
				a += abc[i]/(i-1);
			}
		}
		return a;
	}
	
	//Which exceptions could possible occur in this method?
	//How can we modify this method using try-catch blocks to prevent it from crashing?
	public static void exception2(){
		int[] array;
		int r = (int)(Math.random()*3);
		if (r>0)
			array = new int[r];
		else 
			array = null;
		int k = (int)(Math.random()*5);
		array[k] = r/k;
	}
	
	//This method continually asks the user for a valid integer and prints it once they do
	//Uses exceptions to prevent crashing
	public static void exception3(){
		Scanner sc = new Scanner(System.in);
		int x = 0;
		boolean valid = false;
		while (!valid){
			try{
				System.out.println("Enter a positive integer");
				x = sc.nextInt();
				if (x>=0){
					valid = true;
				} else {
					System.out.println("Not positive");
				}
			} catch (InputMismatchException e){
				System.out.println("Not an integer");
				sc.nextLine();
			}
		}
		System.out.println("You entered: "+x);
	}
	
	/*//////////////////
	 * ARRAYLISTS
	 *//////////////////
	
	//What prints after this method is run?
	public static void arraylist1(){
		ArrayList<Double> numbers = new ArrayList<Double>();
		Double d1 = new Double(12.3);
		double d2 = 1.21;
		
		numbers.add(d1);
		numbers.add(0.0);
		numbers.add(d2);
		numbers.add(new Double(-9.73));
		
		numbers.remove(1.21);
		numbers.set(2, 1.21);
		numbers.add(1, -31.1);
		System.out.println(numbers.get(2));
		System.out.println(numbers.indexOf(-9.73));
	}
	
	//What does the following method print?
	public static void arraylist2(){
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(2);
		integers.add(5);
		integers.add(5);
		integers.set(integers.indexOf(5), 2);
		integers.add(integers.indexOf(2), 5);
		integers.set(integers.indexOf(5), integers.get(integers.indexOf(2)+1));
		System.out.println(integers);
	}
	
	/*//////////////////
	 * RECURSION
	 *//////////////////
	
	//Recursively compute the factorial of a positive integer
	public static int factorial(int n){
		if (n==0)
			return 1;
		else if (n>0)
			return n*factorial(n-1);
		else
			throw new IllegalArgumentException("Can't compute factorial of negative numbers");
	}
	
	//recSum() recursively computes the sum of the elements in a double array
	//We pass the index because in the recursive call we need a way to tell Java to check the next index
	//For the method to work properly we must call it with an initial index of 0
	private static double recSum(double[] arr, int index){
		if (index==arr.length-1){
			return arr[index];
		} else {
			return arr[index]+recSum(arr, index+1);
		}
	}
	
	//sum() takes care of the fact that we must initially call recSum() with an index of 0
	public static double sum(double[] arr){
		return recSum(arr, 0);
	}
	
	//disj() recursively computes the disjunction of an array of booleans
	//If any of the booleans in the array are true then the disjunction is true
	private static boolean disj(boolean[] arr, int index){
		if (index==arr.length-1){
			return arr[index];
		} else {
			return arr[index] || disj(arr, index+1);
		}
	}
	
	//disjunction() takes care of the fact that we must initially call disj() with an index of 0
	public static boolean disjunction(boolean[] arr){
		return disj(arr, 0);
	}
	
	//conj() recursively computes the conjunction of an array of booleans
	//If all of the booleans in the array are true then the conjunction is true
	private static boolean conj(boolean[] arr, int index){
		if (index==arr.length-1){
			return arr[index];
		} else {
			return arr[index] && conj(arr, index+1);
		}
	}
	
	//conjunction() takes care of the fact that we must initially call conj() with an index of 0
	public static boolean conjunction(boolean[] arr){
		return conj(arr, 0);
	}
	
	/*//////////////////////////
	 * OTHER USEFUL METHODS
	 *//////////////////////////
	public static void print2DArray(int[][] arr){
		for (int i=0; i<arr.length; i++){
			for (int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print2DArray(double[][] arr){
		for (int i=0; i<arr.length; i++){
			for (int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}