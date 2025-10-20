package chatGPT.dataStructure.list;

import java.util.StringJoiner;

/**
 * 연결리스트 - 은행 고객 시스템
 */
public class BankSystem {
	public static void main(String[] args) {
		CustomerList list1 = new CustomerList();
		list1.addSorted("Alice", 1);
		list1.addSorted("Bob", 3);
		list1.addSorted("Diana", 4);


		CustomerList list2 = new CustomerList();
		list2.addSorted("Charlie", 2);
		list2.addSorted("Zen", 5);

		System.out.print("💙 list1: ");
		list1.printCustomers();

		System.out.print("💛 list2: ");
		list2.printCustomers();

		System.out.print("🖤 두 리스트 병합 결과: ");
		CustomerList.mergeAndSort(list1, list2).printCustomers();
	}
}

class CustomerList {
	private Node head;	//시작 노드

	//새로운 고객 추가
	public void addSorted(String name, int priority) {
		Node newNode = new Node(name, priority);

		if( head == null || head.priority >= priority ) {
			newNode.next = head;
			head = newNode;

			return;
		}

		Node current = head;
		while( current.next != null && current.next.priority < priority) {
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;
	}

	//기존 고객 대기 취소
	public void removeByName(String name) {
		if( head == null ) {
			System.out.println("현재 대기중인 고객이 아무도 없습니다.");
			return;
		}

		Node current = head;
		Node prev = null;

		while ( current != null ) {
			if( current.name.equals(name) ) {
				if( prev == null ) head = current.next;
				else prev.next = current.next;

				System.out.println(name + " 고객 대기 취소 완료!");
				printCustomers();
				return;
			}

			prev = current;
			current = current.next;
		}

		System.out.println(name + " 고객님은 현재 대기중이 아닙니다!");
	}

	public static CustomerList mergeAndSort(CustomerList list1, CustomerList list2) {
		if( list1 == null || list1.head == null ) return list2;
		if( list2 == null || list2.head == null ) return list1;

		CustomerList result = new CustomerList();

		Node node1 = list1.head;
		Node node2 = list2.head;
		Node merge = null;
		while( node1 != null && node2 != null ) {
			Node small;
			if( node1.priority > node2.priority ) {
				small = new Node( node2.name, node2.priority );
				node2 = node2.next;
			}else {
				small = new Node(node1.name, node1.priority);
				node1 = node1.next;
			}

			if( result.head == null ) {
				result.head = small;
				merge = small;
			}else {
				merge.next = small;
				merge = small;
			}
		}

		while ( node1 != null ) {
			merge.next = new Node(node1.name, node1.priority);
			merge = node1.next;
			node1 = node1.next;
		}

		while ( node2 != null ) {
			merge.next = new Node(node2.name, node2.priority);

			merge = node2.next;
			node2 = node2.next;
		}

		return result;
	}



	//고객 이름 출력
	public void printCustomers() {
		StringJoiner joiner = new StringJoiner(" -> ");
		Node current = head;

		while ( current != null ) {
			joiner.add(String.format("%s(%d)", current.name, current.priority));

			current = current.next;
		}

		System.out.println(joiner);
	}
}

class Node {
	final String name;
	int priority;
	Node next;

	Node(String name, int priority) {
		this.name = name;
		this.priority = priority;

		this.next = null;
	}
}