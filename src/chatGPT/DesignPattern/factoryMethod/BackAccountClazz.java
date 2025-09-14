package chatGPT.DesignPattern.factoryMethod;

/**
 * 팩토리메서드 패턴 - 은행 계좌 생성
 */
public class BackAccountClazz {
	public static void main(String[] args) {
		AccountFactory checkingFactory = CheckingFactory.getInstance();
		AccountFactory savingFactory = SavingFactory.getInstance();
		AccountFactory businessFactory = BusinessFactory.getInstance();

		checkingFactory.openAccount();
		checkingFactory.openAccount();
		checkingFactory.openAccount();
		checkingFactory.openAccount();

		savingFactory.openAccount();
		savingFactory.openAccount();
		savingFactory.openAccount();

		businessFactory.openAccount();
		businessFactory.openAccount();

		System.out.println("checking count: " + checkingFactory.getCreatedCount());
		System.out.println("saving count: " + savingFactory.getCreatedCount());
		System.out.println("business count: " + businessFactory.getCreatedCount());
	}
}

interface Account {
	void create();
	double getInterestRate();
	long getLimit();
}

class CheckingAccount implements Account{
	@Override
	public void create() {
		System.out.println("CheckingAccount created: interest=" + getInterestRate() + "%, limit=" + getLimit());
	}

	@Override
	public double getInterestRate() {
		return 0.1;
	}

	@Override
	public long getLimit() {
		return 5000;
	}
}

class SavingAccount implements Account {
	@Override
	public void create() {
		System.out.println("SavingAccount created: interest=" + getInterestRate() + "%, limit=" + getLimit());
	}

	@Override
	public double getInterestRate() {
		return 1.2;
	}

	@Override
	public long getLimit() {
		return 10000;
	}
}

class BusinessAccount implements Account {
	@Override
	public void create() {
		System.out.println("BusinessAccount created: interest=" + getInterestRate() + "%, limit=" + getLimit());
	}

	@Override
	public double getInterestRate() {
		return 0.5;
	}

	@Override
	public long getLimit() {
		return 50000;
	}
}

abstract class AccountFactory {

	public void openAccount() {
		Account account = createAccount();
		account.create();
	}

	protected abstract Account createAccount();

	public abstract int getCreatedCount();
}

class CheckingFactory extends AccountFactory {
	private static int count = 0;
	public static CheckingFactory factory;

	private CheckingFactory() {}

	public static CheckingFactory getInstance() {
		if( factory == null ) {
			factory = new CheckingFactory();
		}

		return factory;
	}

	@Override
	protected Account createAccount() {
		count++;
		return new CheckingAccount();
	}

	@Override
	public int getCreatedCount() {
		return count;
	}
}

class SavingFactory extends AccountFactory {
	private static int count = 0;
	private static SavingFactory factory;

	private SavingFactory() {}

	public static SavingFactory getInstance() {
		if( factory == null ) {
			factory = new SavingFactory();
		}

		return factory;
	}

	@Override
	protected Account createAccount() {
		count++;
		return new SavingAccount();
	}

	@Override
	public int getCreatedCount() {
		return count;
	}
}

class BusinessFactory extends AccountFactory {
	public static BusinessFactory factory;
	private static int count = 0;

	private BusinessFactory() {}

	public static BusinessFactory getInstance() {
		if( factory == null ) {
			factory = new BusinessFactory();
		}

		return factory;
	}

	@Override
	protected Account createAccount() {
		count++;
		return new BusinessAccount();
	}

	@Override
	public int getCreatedCount() {
		return count;
	}
}