package chatGPT;

/**
 	멀티 스레드 문제 - 문자열 각각 출력
 */
public class StringThread {
	public static void main(String[] args) {
		//Thread 상속
		Thread helloThread = new MyThread("Hello");
		Thread worldThread = new MyThread("World");
		helloThread.start();
		worldThread.start();

		//Runnable 인터페이스 구현
		Thread  helloRunnable = new Thread(new MyRunnable("Hello"));
		Thread  worldRunnable = new Thread(new MyRunnable("World"));
		helloRunnable.start();
		worldRunnable.start();
	}
}

class MyThread extends Thread {
	private String text;

	public MyThread(String text) {
		this.text = text;
	}

	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName() + text);
		}
	}
}

class MyRunnable implements Runnable {

	private String text;

	public MyRunnable(String text) {
		this.text = text;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + text);
		}
	}
}
