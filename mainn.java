import java.lang.*;
public class Person {
    int age;
	String name;
	
	Person(){
		System.out.println("Default Constructor");
	}
	Person(String name,int age){
		System.out.println("Parametarized Constructor");
		this.name=name;
		this.age=age;
	}
	public void show(){
		System.out.println("Name:"+name);	 
	System.out.println("Age:"+age); }
	public static class Employee extends Person {
		 int id;
		 float salary;
		 String companyname;
		public Employee(String name,int age,int id,float salary,String companyname){
			super(name,age);
			this.id=id;
			this.salary=salary;
			this.companyname=companyname;
		}
		public void show(){
		System.out.println("Name:"+name);	 
		System.out.println("Age:"+age); 
		System.out.println("ID:"+id); 
		System.out.println("Salary:"+salary); 
	    System.out.println("Company Name:"+companyname);}
		public class mainn{
	public static void main(String[] args){
        Person p1=new Person("Abrar",23);
        p1.show();
        Employee e1=new Employee("Labib",21,120,21000,"nike");
		e1.show();
}}}}
