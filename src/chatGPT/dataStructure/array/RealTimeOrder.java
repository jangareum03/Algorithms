package chatGPT.dataStructure.array;

/**
 * 배열 - 실시간 주문 처리 시물레이터
 */
public class RealTimeOrder {
	public static void main(String[] args) {
		Order[] orders = {
				new Order("O001", 1, 5),
				new Order("O002", 3, 2),
				new Order("O003", 6, 4)
		};

		int currentTime = 0;	//현재 시간
		for(Order o : orders) {
			currentTime = Math.max( currentTime, o.getOrderTime() );	//현재 시간과 주문시각 중 큰 값을 현재 시간으로 업데이트

			currentTime += o.getCookTime();	//현재 시간에서 요리시간을 더해야 요리 완료된 시간 알 수 있음

			System.out.println(o.getId() + "주문 완료 시간: " + currentTime);
		}
	}
}

class Order {
	private final String id;
	private final int orderTime;
	private int cookTime;

	public Order(String id, int orderTime, int cookTime) {
		this.id = id;
		this.orderTime = orderTime;
		this.cookTime = cookTime;
	}

	public String getId() {
		return id;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public int getCookTime() {
		return cookTime;
	}
}