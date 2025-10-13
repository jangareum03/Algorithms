package chatGPT.sort.selection;

import java.util.Arrays;

/**
 * 선택 정렬 - 포인트 내림차순
 */
public class PointSort {
	public static void main(String[] args) {
		Customer[] list = {
				new Customer("Alice", 520),
				new Customer("Bob", 350),
				new Customer("Charlie", 790),
				new Customer("Diana", 410)
		};

		descPointByCustomer(list);
		System.out.println(Arrays.toString(list));
	}

	private static void descPointByCustomer(Customer[] customers) {
		for( int i=0; i<customers.length; i++ ) {
			int maxIndex = i;

			for( int j=i+1; j<customers.length; j++ ) {
				if( customers[maxIndex].point < customers[j].point ) {
					maxIndex = j;
				}
			}

			Customer temp = customers[maxIndex];
			customers[maxIndex] = customers[i];
			customers[i] = temp;
		}

	}
}

class Customer {
	String name;
	int point;

	Customer(String name, int point) {
		this.name = name;
		this.point = point;
	}

	@Override
	public String toString() {
		return name + "(" + point +")";
	}
}