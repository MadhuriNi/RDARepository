package ca.demo.salestool;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalesData data=new SalesData();
		displayGreeting();
		data.display();

		System.out.println("---------");
	}
	
	public static void displayGreeting()
	{
		System.out.println("Hello happiee sales peeps !!!");
		System.out.println("This app shows sales data");
		
		System.out.println("-------Configuring in git hub--------");
	}

}
