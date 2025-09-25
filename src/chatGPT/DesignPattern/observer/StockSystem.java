package chatGPT.DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴 - 주식 시세 알림
 */
public class StockSystem {
	public static void main(String[] args) {
		Stock stock = new Stock();

		stock.add("A");
		stock.add("B");

		stock.invest(60000);
		stock.invest(61500);
		stock.invest(63000);
	}
}

class Stock {
	private List<Investor> investors = new ArrayList<>();

	public void add(String name) {
		investors.add(new Investor(name));
	}

	public void invest(int price) {
		for(Investor i : investors ) {
			i.show(price);
		}
	}
}

class Investor {
	private String name;

	public Investor(String  name) {
		this.name = name;
	}

	public void show(int price) {
		System.out.printf("[Investor: %s] 삼성전자 주가 변동: %d원%n", name, price);
	}
}