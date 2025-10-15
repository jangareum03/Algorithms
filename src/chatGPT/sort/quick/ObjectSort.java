package chatGPT.sort.quick;

/**
 * 퀵 정렬 - 상품 가격 오름차순
 */
public class ObjectSort {
	public static void main(String[] args) {
		Product[] products = {
				new Product("Keyboard", 35000),
				new Product("Mouse", 15000),
				new Product("Monitor", 120000),
				new Product("USB", 8000)
		};

		quickSort(products, 0, products.length - 1);
		for( Product p : products ) System.out.println(p.toString());
	}

	private static void quickSort(Product[] products, int start, int end) {
		if( start >= end ) return;

		int point = partition(products, start, end);
		quickSort(products, start, point - 1);			//피벗 기준으로 왼쪽 그룹 퀵 정렬 시작
		quickSort( products, point + 1, end );		//피벗 기준으로 오른쪽 그룹 퀵 정렬 시작
	}

	private static int partition(Product[] products, int start, int end) {
		Product pivot = products[end];	//배열의 마지막을 피벗으로

		int move = start - 1;		//피벗기준으로 작은값을 옮길 인덱스 위치
		for( int i=start; i<end; i++ ) {
			if( pivot.getPrice() > products[i].getPrice() ) {
				move++;

				Product temp = products[move];
				products[move] = products[i];
				products[i] = temp;
			}
		}

		Product temp = products[move + 1];
		products[move + 1] = products[end];
		products[end] = temp;

		return move+1;
	}
}

class Product {
	private final String name;
	private final int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName() + " - " + getPrice();
	}
}