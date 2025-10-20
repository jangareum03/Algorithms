package chatGPT.dataStructure.list;

import java.time.LocalDate;

/**
 * 단일 연결 리스트 - 고객 거래
 */
public class BankTransaction {
	public static void main(String[] args) {
		TransactionList transaction = new TransactionList();

		transaction.addTransaction(101, 50000, "2025-10-10");
		transaction.addTransaction(102, -20000, "2025-10-11");
		transaction.addTransaction(103, 30000, "2025-10-11");

		transaction.removeTransaction(101);
		transaction.findByDate("2025-10-11");

		System.out.println("Total Amount: " + transaction.getTotalAmount());
	}
}

class TransactionList {
	Transaction head;

	public void addTransaction(int id, double amount, String date) {
		Transaction newNode = new Transaction(id, amount, date);

		if( head == null ) {
			head = newNode;

			return;
		}

		Transaction node = head;
		while (node.next != null) {
			node = node.next;
		}

		node.next = newNode;
	}

	public void removeTransaction(int id) {
		Transaction node = head;
		Transaction prev = null;

		while(node != null) {
			if( node.id == id ) {
				if( prev == null ) head = node.next;
				else prev.next = node.next;

				return;
			}

			prev = node;
			node = node.next;
		}

		System.out.println("해당 거래는 없는 내역이므로 삭제할 수 없습니다: " + id);
	}

	public double getTotalAmount() {
		double totalAmount = 0;

		Transaction node = head;
		while ( node != null ) {
			totalAmount += node.amount;
			node = node.next;
		}

		return totalAmount;
	}

	public void findByDate(String date) {
		System.out.println("Transactions on " + date);

		boolean isFind = false;
		LocalDate search = LocalDate.parse(date);
		Transaction node = head;
		while ( node != null ) {
			LocalDate transactionDate = LocalDate.parse(node.date);

			if( search.isEqual(transactionDate) ) {
				isFind = true;
				System.out.printf("ID: %d, Amount: %f%n", node.id, node.amount);
			}

			node = node.next;
		}

		if( !isFind ) {
			System.out.println("해당 날짜의 거래 내역은 없습니다.: " + date);
		}
	}
}

class Transaction {
	int id;
	double amount;
	String date;
	Transaction next;

	Transaction(int id, double amount, String date) {
		this.id = id;
		this.amount = amount;
		this.date = date;

		this.next = null;
	}
}