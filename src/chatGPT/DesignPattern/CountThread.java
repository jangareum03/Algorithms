package chatGPT.DesignPattern;

/**
	멀티 스레드 문제 - 각 스레드 1000번까지 카운트
 */
public class CountThread {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread t1 = new Thread(new CounterThread(counter));
		Thread t2 = new Thread(new CounterThread(counter));
		Thread t3 = new Thread(new CounterThread(counter));
		Thread t4 = new Thread(new CounterThread(counter));
		Thread t5 = new Thread(new CounterThread(counter));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();

		System.out.println("최종 count = " + counter.count);
	}
}

class Counter {
	int count = 0;

	public synchronized void increment() {
		count++;
	}
}

class CounterThread implements Runnable {
	private Counter counter;
	private int i =0;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while ( i < 1000 ) {
			counter.increment();
			++i;
		}
	}
}
