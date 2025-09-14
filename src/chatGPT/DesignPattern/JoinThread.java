package chatGPT.DesignPattern;

/**
	멀티 스레드 문제 - 모든 스레드 종료 확인
 */
public class JoinThread {
	public static void main(String[] args) throws InterruptedException {
		Thread numberThread = new NumberThread();
		Thread starThread = new Thread(new StarThread());

		numberThread.start();
		starThread.start();

		System.out.println("Done!");

	}
}

class NumberThread extends Thread{
	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
	}
}

class StarThread implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + " - ★");
		}
	}
}