package chatGPT.DesignPattern.strategy;

/**
 * 전략 패턴 - 피자 할인 정책
 */
public class PizzaDiscount {
	public static void main(String[] args) {
		PizzaOrder order = new PizzaOrder(new StudentDiscount());
		order.discount(20000);

		order = new PizzaOrder(new VipDiscount());
		order.discount(20000);

		order = new PizzaOrder(new NoDiscount());
		order.discount(20000);
	}
}

interface DiscountStrategy {
	void applyDiscount(int price);
}

class StudentDiscount implements DiscountStrategy {
	@Override
	public void applyDiscount(int price) {
		System.out.printf("[학생 할인 적용] 최종 결제 금액 : %d원%n", (int) (price * 0.9) );
	}
}

class  VipDiscount implements DiscountStrategy {
	@Override
	public void applyDiscount(int price) {
		System.out.printf("[VIP 할인 적용] 최종 결제 금액: %d원%n", (int)(price * 0.8));
	}
}

class NoDiscount implements DiscountStrategy {
	@Override
	public void applyDiscount(int price) {
		System.out.println("[할인 없음] 최종 결제 금액: " + price + "원");
	}
}

class PizzaOrder {
	private DiscountStrategy strategy;

	public PizzaOrder(DiscountStrategy discountStrategy) {
		this.strategy =discountStrategy;
	}

	public void discount(int price) {
		strategy.applyDiscount(price);
	}
}