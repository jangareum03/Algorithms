package chatGPT.DesignPattern.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로토타입 패턴 - 쇼핑몰 상품
 */
public class ShoppingProduct {
	public static void main(String[] args) throws CloneNotSupportedException {
		Cart cart = new Cart();

		//티셔츠 설정
		Map<String, String> options = new HashMap<>();
		options.put("색상", "블루");
		options.put("사이즈", "M");

		Product tShirt = new Product("티셔츠", 20000, options);
		System.out.println("상품 생성: " + tShirt.getInfo());
		cart.add(tShirt);

		//상품 복제
		Product copyShirt = tShirt.clone();
		copyShirt.setOption("색상", "빨강");
		copyShirt.setOption("사이즈", "L");

		System.out.println("상품 복제 후 장바구니 담기");
		cart.add(copyShirt);

		cart.show();
	}
}

class Product implements Cloneable{
	private final String name;
	private final int price;
	private final Map<String, String> options;

	public Product(String name, int price, Map<String, String> options) {
		this.name = name;
		this.price = price;
		this.options = options;
	}

	@Override
	public Product clone() throws CloneNotSupportedException {
		return new Product( this.name, this.price, new HashMap<>(this.options) );
	}

	public String getInfo() {
		return name + ", 가격=" + price + ", 옵션=" + getOptions();
	}

	public String getName() {
		return name;
	}

	public String getOptions() {
		return options.toString();
	}

	public void setOption(String key, String value) {
		options.put(key ,value);
	}
}

class Cart {
	private List<Product> cartList = new ArrayList<>();

	public void add(Product product) {
		cartList.add(product);
	}

	public void show() {
		for( int i=0; i<cartList.size(); i++ ) {
			Product product = cartList.get(i);

			System.out.println("장바구니" + (i+1) + "상품: " + product.getName() + ", 옵션=" + product.getOptions());
		}
	}
}