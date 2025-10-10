package chatGPT.DesignPattern.chain;

/**
 * 책임 연쇄 패턴 - 쇼핑몰 주문 할인
 */
public class ShoppingChain {
	public static void main(String[] args) {
		DiscountHandler vip = new VIP();
		DiscountHandler gold = new Gold();
		DiscountHandler silver = new Silver();
		DiscountHandler normal = new Normal();

		vip.setNextHandler(gold);
		gold.setNextHandler(silver);
		silver.setNextHandler(normal);

		vip.request();
	}
}

abstract class DiscountHandler {
	protected DiscountHandler nextHandler;

	public void setNextHandler(DiscountHandler handler) {
		this.nextHandler = handler;
	}

	protected abstract void request();
}

class VIP extends DiscountHandler {
	@Override
	protected void request() {
		System.out.println("VIP 고객: 30% 할인 적용");

		if( nextHandler != null ) {
			nextHandler.request();
		}
	}
}

class Gold extends DiscountHandler {
	@Override
	protected void request() {
		System.out.println("Gold 고객: 20% 할인 적용");

		if( nextHandler != null ) {
			nextHandler.request();
		}
	}
}

class Silver extends DiscountHandler {
	@Override
	protected void request() {
		System.out.println("Silver 고객: 10% 할인 적용");

		if( nextHandler != null ) {
			nextHandler.request();
		}
	}
}

class Normal extends DiscountHandler {
	@Override
	protected void request() {
		System.out.println("일반 고객: 할인 없음");
	}
}