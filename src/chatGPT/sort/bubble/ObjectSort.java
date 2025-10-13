package chatGPT.sort.bubble;


/**
 * 버블 정렬 - 상품 가격 오름차순 정렬
 */
public class ObjectSort {
	public static void main(String[] args) {
		Product[] products = {
				new Product("Keyboard", 25000),
				new Product("Mouse", 12000),
				new Product("Monitor", 180000),
				new Product("USB", 8000)
		};

		long start = System.nanoTime();
		sortProductsByPriceAsc(products);
		long end = System.nanoTime();

		System.out.println("정렬 소요시간: " + (end - start) + "ns");
	}

	public static void sortProductsByPriceAsc(Product[] products) {
		boolean swaped;
		for( int i=0; i<products.length; i++ ) {
			swaped = false;

			for( int j=0; j<products.length-1-i; j++ ) {
				if( products[j].price > products[j+1].price ) {
					Product temp = products[j];
					products[j] = products[j+1];
					products[j+1] = temp;

					swaped = true;
				}
			}

			if(!swaped) break;
		}

		showProducts(products);
	}

	private static void showProducts(Product[] products) {
		for(Product p : products) {
			System.out.printf("%s - %d%n", p.name, p.price);
		}
	}
}

class Product {
	String name;
	int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
}