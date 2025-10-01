package chatGPT.DesignPattern.state;

/**
 * 상태 패턴 - 온라인 주문
 */
public class OrderSystem {
	public static void main(String[] args) {
		Order order = new Order();
		for( int i=0; i<3; i++ ) {
			order.process();
		}
	}
}

class Order {
	private OrderState state;

	public Order() {
		this.state = new OrderReceivedState();
	}

	public void process() {
		state.change(this);
	}

	public void setState(OrderState state) {
		this.state = state;
	}
}

interface OrderState {
	void change(Order order);
}

class OrderReceivedState implements OrderState {
	@Override
	public void change(Order order) {
		System.out.println("주문 접수 완료");
		order.setState(new ShippingState());
	}
}
class ShippingState implements OrderState {
	@Override
	public void change(Order order) {
		System.out.println("배송 시작");
		order.setState(new DeliveredState());
	}
}
class DeliveredState implements OrderState {
	@Override
	public void change(Order order) {
		System.out.println("배송 완료");
	}
}