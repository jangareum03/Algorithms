package chatGPT.sort.shell;

/**
 * 셸 정렬 - 상품 가격 오름차순
 */
public class ObjectSort {
	public static void main(String[] args) {
		Product[] items = {
				new Product("Keyboard", 40000),
				new Product("Mouse", 20000),
				new Product("Monitor", 150000),
				new Product("Cable", 20000)
		};

		shellSort(items);
		for ( int i=0; i<items.length; i++ ) {
			if( i+1 == items.length ) {
				System.out.print(items[i]);
			}else {
				System.out.print(items[i] + ", ");
			}
		}
	}

	private static void shellSort(Product[] products) {
		int n = products.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {        //for문을 돌릴수록 gap이 2씩 줄어들어 gap이 1미만이되면 반복문 벗어남
			for (int i = gap; i < n; i++) {        //gap기준으로 1씩 증가하여 인덱스 끝까지 진행
				Product temp = products[i];        //비교값

				int j=i;

				while (
						j >= gap &&
								(products[j - gap].getPrice() > temp.getPrice() ||
										(products[j-gap].getPrice() == temp.getPrice() && products[j-gap].getName().compareTo(temp.getName()) > 0)
								)) {
					products[j] = products[j-gap];
					j -= gap;
				}

				products[j] = temp;


				products[j] = temp;
			}
		}
	}
}

class Product {
	private final String name;
	private final int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s(%d)", name, price);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}