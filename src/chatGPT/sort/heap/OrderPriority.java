package chatGPT.sort.heap;

/**
 * 힙 정렬 - 주문 내림차순
 */
public class OrderPriority {
	public static void main(String[] args) {
		Order[] orders = {
				new Order("A102", 3),
				new Order("A103", 5),
				new Order("A101", 2),
				new Order("A104", 4)
		};

		heapSort(orders);
		for( Order o : orders ) System.out.print(o.getId() +"  ");
	}

	private static void heapSort(Order[] orders) {
		//최소힙 구하기 (내림차순으로 정렬하기 때문에 루트에는 가장 작은 값이 있어야 함)
		for( int i=orders.length /2 -1; i>=0; i-- ) {
			heapify( orders, orders.length, i);
		}

		for( int i=orders.length -1; i >= 0; i-- ) {
			Order temp = orders[i];
			orders[i] = orders[0];
			orders[0] = temp;

			heapify(orders, i, 0);
		}
	}

	private static void heapify(Order[] orders, int length, int root) {
		int r = root;
		int left = root * 2 + 1;
		int right = root * 2 +2;

		if( left < length && orders[left].getPriority() < orders[r].getPriority() ) {
			r = left;
		}

		if( right < length && orders[right].getPriority() < orders[r].getPriority() ) {
			r = right;
		}

		if( root != r ) {
			Order temp = orders[root];
			orders[root] = orders[r];
			orders[r] = temp;

			heapify( orders, length, r );
		}
	}
}

class Order {
	private final String id;
	private final int priority;

	public Order(String  id, int priority) {
		this.id = id;
		this.priority = priority;
	}


	public String getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}

}