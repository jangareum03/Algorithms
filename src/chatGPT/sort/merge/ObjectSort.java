package chatGPT.sort.merge;

import java.util.Arrays;

/**
 * 병합 정렬 - 가격 오름차순, 이름 오름차순
 */
public class ObjectSort {
	public static void main(String[] args) {
		Product[] products = {
				new Product("Keyboard", 35000),
				new Product("Mouse", 15000),
				new Product("Monitor", 35000)
		};

		Product[] sorted = mergeSortProducts(products);

		for (Product p : sorted) {
			System.out.println(p.getName() + " - " + p.getPrice());
		}
	}

	private static Product[] mergeSortProducts(Product[] products) {
		if( products.length <= 1 ) return products;

		int mid = products.length / 2;
		Product[] left = Arrays.copyOfRange( products, 0, mid );
		Product[] right = Arrays.copyOfRange( products, mid, products.length );

		left = mergeSortProducts(left);
		right = mergeSortProducts(right);

		return mergeProducts(left, right);
	}

	private static Product[] mergeProducts(Product[] left, Product[] right) {
		Product[] merge = new Product[left.length + right.length];

		int r = 0, l = 0, m = 0;

		while ( l < left.length && r < right.length ) {
			if( left[l].getPrice() < right[r].getPrice() ||
					(left[l].getPrice() == right[r].getPrice() && left[l].getName().compareTo(right[r].getName()) <= 0)) {
				merge[m++] = left[l++];
			}else {
				merge[m++] = right[r++];
			}
		}

		while( l < left.length ) {
			merge[m++] = left[l++];
		}

		while( r < right.length ) {
			merge[m++] = right[r++];
		}

		return merge;
	}
}

class Product {
	private final String name;
	private final int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}