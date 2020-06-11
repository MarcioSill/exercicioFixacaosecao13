package appication;


import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.item.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException  {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
				
		System.out.println("Enter cliente data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");		
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();		
		
		for (int i = 1; i <= N; i++) {
			sc.nextLine();
			System.out.println("Enter # " + i + " item data: ");			
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			Product product = new Product(productName, price);
			
			System.out.print("Quantity :");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, price, product);	
			order.addItem(orderItem);			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		/*System.out.println("Order status: "+ order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + "("+ order.getClient().getBirthDate() +")" + order.getClient().getEmail());
		
		/*System.out.println();
        System.out.println("Order items: ");
        System.out.println(order.toString());*/     
        
		sc.close();

	} 

}
