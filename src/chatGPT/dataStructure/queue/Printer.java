package chatGPT.dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐 - 프린터 작업 스케줄링
 */
public class Printer {
	public static void main(String[] args) throws InterruptedException {
		Queue<PrintJob> printJobs = new LinkedList<>();

		printJobs.offer(new PrintJob(1, 10));
		printJobs.offer(new PrintJob(2, 5));
		printJobs.offer(new PrintJob(3, 7));
		printJobs.offer(new PrintJob(4, 3));

		while ( !printJobs.isEmpty() ) {
			PrintJob job = printJobs.poll();

			job.view();
		}
		System.out.println("모든 작업 완료");
	}
}

class PrintJob {
	final int id;
	final int page;

	public PrintJob(int id, int pages) {
		this.id = id;
		this.page = pages;
	}

	public void view() throws InterruptedException {
		Thread.sleep(page * 100);
		System.out.printf("작업 ID: %d, 페이지: %d 인쇄 완료%n", id, page);
	}
}