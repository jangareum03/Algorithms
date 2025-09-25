package chatGPT.DesignPattern.observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴 - 상품 재고 알림
 */
public class OnlineProduct {
	public static void main(String[] args) {
		Product noteBook = new Product("노트북");

		Customer kim = new Customer("Kim");
		Customer lee = new Customer("Lee");

		noteBook.subscribe(kim);
		noteBook.subscribe(lee);

		noteBook.update();

		noteBook.cancel(lee);
		noteBook.update();
	}
}

class Product {
	private final String name;
	private List<Customer> customers = new ArrayList<>();

	public Product(String name) {
		this.name = name;
	}

	public void subscribe(Customer customer) {
		customers.add(customer);
	}

	public void cancel(Customer customer) {
		customers.remove(customer);
		System.out.printf("(고객 %s 구독 취소)%n", customer.getName());
	}

	public void update() {
		for(Customer c : customers) {
			c.notice(name);
		}
	}
}

class Customer {
	private final String name;

	public Customer(String name) {
		this.name = name;
	}

	public void notice(String productName) {
		System.out.printf("[Customer: %s] 상품 '%s'이 재입고 되었습니다!%n", name, productName);
	}

	public String getName() {
		return name;
	}
}