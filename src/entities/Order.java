package entities;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.item.OrderStatus; 

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat(" dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;	
	private List<OrderItem>items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);		
	}
	
	public double Total() {
		double soma = 0;
		for (OrderItem c : items) {
			soma += c.subTotal(); // soma  todo dos produtos subtotal 
		}
		return soma ;
	}
	
	@Override
		
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		
		sb.append("Order items: \n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: R$");
		sb.append(String.format("%.2f", Total()));
		return sb.toString();
		
		
	}

}
