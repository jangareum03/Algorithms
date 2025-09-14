package chatGPT.DesignPattern;


/**
 	멀티 스레드 문제  - 버퍼로 숫자 넣고 빼기
 */
public class ProducerConsumerBuffer {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();

		Thread producer = new Thread(new Producer(buffer), "Producer");
		Thread consumer = new Thread(new Consumer(buffer), "consumer");

		producer.start();
		consumer.start();
	}
}

class Buffer {
	private boolean isFull = false;
	private int value;

	public synchronized void add(int number) throws InterruptedException {
		while (isFull) {
			wait();
		}

		value = number;
		System.out.println(Thread.currentThread().getName() + " - " + value + " 생산");
		isFull = true;

		notify();
	}

	public synchronized void remove() throws InterruptedException {
		while ( !isFull ) {
			wait();
		}

		System.out.println(Thread.currentThread().getName() + " - " + value + " 소비");
		value = 0;
		isFull = false;

		notify();
	}
}

class Producer implements Runnable {
	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			try {
				buffer.add(i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class Consumer implements Runnable {
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			try {
				buffer.remove();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}