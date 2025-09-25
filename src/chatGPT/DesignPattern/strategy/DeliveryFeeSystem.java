package chatGPT.DesignPattern.strategy;

/**
 * 전략 패턴 - 배송비 계산
 */
public class DeliveryFeeSystem {
	public static void main(String[] args) {
		Order order = new Order(new CourierDelivery());
		order.calculateTotalPrice(50000);

		order.setStrategy(new ConvenienceStoreDelivery());
		order.calculateTotalPrice(50000);

		order.setStrategy(new QuickDelivery());
		order.calculateTotalPrice(50000);
	}
}

interface DeliveryStrategy {
	void calculateFee(int basePrice);
}

class CourierDelivery implements DeliveryStrategy {
	@Override
	public void calculateFee(int basePrice) {
		System.out.printf("[택배 배송] 총 결제 금액: %d원%n", basePrice + 3000);
	}
}

class ConvenienceStoreDelivery implements DeliveryStrategy {
	@Override
	public void calculateFee(int basePrice) {
		System.out.printf("[편의점 픽업] 총 결제 금액: %d원%n", basePrice + 1500);
	}
}

class QuickDelivery implements DeliveryStrategy {
	@Override
	public void calculateFee(int basePrice) {
		System.out.printf("[퀵 배송] 총 결제 금액: %d원%n", basePrice+7000);
	}
}

class Order {
	private DeliveryStrategy strategy;

	public Order( DeliveryStrategy strategy ) {
		this.strategy = strategy;
	}

	public void setStrategy(DeliveryStrategy strategy) {
		this.strategy = strategy;
	}

	public void calculateTotalPrice(int price) {
		if( price >= 50000 ) {
			strategy.calculateFee(price);
		}
	}
}