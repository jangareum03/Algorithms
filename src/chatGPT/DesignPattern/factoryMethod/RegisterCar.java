package chatGPT.DesignPattern.factoryMethod;

/**
 * 팩토리 메서드 패턴 - 자동차 등록 시스템
 */
public class RegisterCar {
	public static void main(String[] args) {
		TransFactory carFactory = new CarFactory();
		TransFactory truckFactory = new TruckFactory();
		TransFactory motorcycleFactory = new MotorcycleFactory();

		Transportation car = carFactory.create();
		car.register();

		Transportation truck = truckFactory.create();
		truck.register();

		Transportation motorcycle = motorcycleFactory.create();
		motorcycle.register();
	}
}

interface Transportation {
	void register();
}

class Car implements Transportation {
	@Override
	public void register() {
		System.out.println("Car registered successfully.");
	}
}

class Truck implements Transportation {
	@Override
	public void register() {
		System.out.println("Truck registered successfully.");
	}
}

class Motorcycle implements Transportation {
	@Override
	public void register() {
		System.out.println("Motorcycle registered successfully.");
	}
}

abstract class TransFactory {
	protected abstract Transportation create();
}

class CarFactory extends TransFactory {
	@Override
	protected Transportation create() {
		return new Car();
	}
}

class TruckFactory extends TransFactory {
	@Override
	protected Transportation create() {
		return new Truck();
	}
}

class MotorcycleFactory extends TransFactory {
	@Override
	protected Transportation create() {
		return new Motorcycle();
	}
}