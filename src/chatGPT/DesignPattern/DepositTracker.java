package chatGPT.DesignPattern;

/**
 * 싱글톤 패턴 문제 - 멀티 스레드 환경
 */
public class DepositTracker {
	public static void main(String[] args) throws InterruptedException {
		Thread p1 = new Thread(new DepositPerson(100), "철수");
		Thread p2 = new Thread(new DepositPerson(200), "영희");
		Thread p3 = new Thread(new DepositPerson(100), "영희");
		Thread p4 = new Thread(new DepositPerson(500), "길동");
		Thread p5 = new Thread(new DepositPerson(100), "철수");
		Thread p6 = new Thread(new DepositPerson(900), "철수");
		Thread p7 = new Thread(new DepositPerson(100), "길동");
		Thread p8 = new Thread(new DepositPerson(200), "길동");
		Thread p9 = new Thread(new DepositPerson(200), "길동");
		Thread p10 = new Thread(new DepositPerson(100), "자바");

		Thread[] threads = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};

		for( Thread t : threads ) t.start();
		for( Thread t : threads ) t.join();

		System.out.println("Total deposited : " + DepositManager.getInstance().getTotal());

		DepositManager d1 = DepositManager.getInstance();
		DepositManager d2 = DepositManager.getInstance();

		System.out.println("Same instance? " + (d1 == d2));
	}
}

class DepositManager {
	private static final DepositManager instance = new DepositManager();
	private long total = 0;

	private DepositManager() {}

	public static DepositManager getInstance() {
		return instance;
	}

	public synchronized void deposit(long amount) {
		total += amount;
	}

	public synchronized long getTotal() {
		return total;
	}
}

class DepositPerson implements Runnable {
	private long amount;

	public DepositPerson( long amount ) {
		this.amount = amount;
	}

	@Override
	public void run() {
		DepositManager.getInstance().deposit(amount);
		System.out.println(Thread.currentThread().getName() + ": " + DepositManager.getInstance().getTotal());
	}
}