package chatGPT.DesignPattern.decorator;

/**
 * 데코레이터 패턴 - 커피 주문 시스템
 */
public class CoffeeOrder {
	public static void main(String[] args) {
		//아메리카노 생성
		Coffee americano = new Americano();

		//우유 추가
		americano = new MilkDecorator(americano);

		//시럽 추가
		americano = new WhipCream(americano);

		System.out.println("주문: " + americano.getDescription());
		System.out.println("결제: " + americano.getCost());
	}
}

//--- 커피 ---
interface Coffee {
	String  getDescription();
	int getCost();
}

//--- 아메리카노 ---
class Americano implements Coffee {
	@Override
	public String getDescription() {
		return "아메리카노";
	}

	@Override
	public int getCost() {
		return 3000;
	}
}

//--- 데코레이터 패턴 ---
abstract class CoffeeDecorator implements Coffee {
	private final Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription();
	}

	@Override
	public int getCost() {
		return coffee.getCost();
	}
}

//--- 우유 ---
class MilkDecorator extends CoffeeDecorator  {
	public MilkDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", 우유";
	}

	@Override
	public int getCost() {
		return super.getCost() + 1000;
	}
}

//--- 시럽 ---
class SyrupDecorator extends CoffeeDecorator {
	public SyrupDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", 시럽";
	}

	@Override
	public int getCost() {
		return super.getCost() + 800;
	}
}

//--- 휘핑크림 ---
class WhipCream extends CoffeeDecorator {

	public WhipCream(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", 휘핑크림";
	}

	@Override
	public int getCost() {
		return super.getCost() + 500;
	}
}