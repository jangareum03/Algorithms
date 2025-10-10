package chatGPT.DesignPattern.visitor;

/**
 * 비지터 패턴 - 쇼핑몰 할인
 */
public class Shopping {
	public static void main(String[] args) {
		DiscountVisitor visitor = new DiscountVisitor();

		visitor.visit(new Electronics("Laptop", 1000));
		visitor.visit(new Clothes("T-Shirt", 50));
		visitor.visit(new Groceries("Apple", 5));

		System.out.println("Total: " + visitor.getTotal());
	}
}

interface Item {
	void accept(DiscountVisitor visitor);
}

class Electronics implements Item {
	private final String name;
	private final int price;

	public Electronics(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void accept(DiscountVisitor visitor) {
		visitor.visit(this);
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}

class Clothes implements Item {
	private final String name;
	private final int price;

	public Clothes(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void accept(DiscountVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

class Groceries implements Item {
	private final String name;
	private final int price;

	public Groceries(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void accept(DiscountVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

class DiscountVisitor {
	private int total = 0;

	public void visit(Electronics electronics) {
		int disPrice = (int) (electronics.getPrice() * 0.9);
		total += disPrice;

		System.out.printf("%s discounted price: %d%n", electronics.getName(), disPrice);
	}

	public void visit(Clothes clothes) {
		int disPrice = (int) (clothes.getPrice() * 0.8);
		total += disPrice;

		System.out.printf("%s discounted price: %d%n", clothes.getName(), disPrice);
	}

	public void visit(Groceries groceries) {
		total += groceries.getPrice();
		System.out.printf("%s discounted price: %d%n", groceries.getName(), groceries.getPrice());
	}

	public int getTotal() {
		return total;
	}
}