import java.util.Scanner;
class Method_Project 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number for number 1");
		int num1=sc.nextInt();
		System.out.println("Enter a number for number 2");
		int num2=sc.nextInt();
		add(num1,num2);
		sub(num1,num2);
		mul(num1,num2);
		div(num1,num2);
		rem(num1,num2);
	}
	public static void add(int a,int b){
		System.out.println("The addition of "+a+" and "+b+" is "+(a+b)+"\n");
	}
	public static void sub(int a,int b){
		System.out.println("The substration of "+a+" and "+b+" is "+(a-b)+"\n");
	}
	public static void mul(int a,int b){
		System.out.println("The multification of "+a+" and "+b+" is "+(a*b)+"\n");
	}
	public static void div(int a,int b){
		System.out.println("The division of "+a+" and "+b+" is "+(a/b)+"\n");
	}
	public static void rem(int a,int b){
		System.out.println("The modulo division of "+a+" and "+b+" is "+(a%b)+"\n");
	}
}
