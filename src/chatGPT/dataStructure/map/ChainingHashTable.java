package chatGPT.dataStructure.map;

import java.util.LinkedList;

/**
 * 해시 테이블 - 체이닝 방식
 */
public class ChainingHashTable {
	static class Node {
		int key, value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<Node>[] table;

	public ChainingHashTable(int size) {
		table = new LinkedList[size];

		for( int i=0; i<size; i++ ) {
			table[i] = new LinkedList<>();
		}
	}

	private int hash(int key) {
		return Math.abs(key) % table.length;
	}

	public void put(int key, int value) {
		int index = hash(key);

		for(Node n : table[index] ) {
			if( n.key == key ) {	//키가 동일하면 값이 수정
				n.value = value;
			}
		}

		//키가 존재하지 않으면 새로운 노드 추가
		table[index].add( new Node(key, value) );
	}

	public Integer get(int key) {
		int index = hash(key);

		for( Node n : table[index] ) {
			if( n.key == key ) {
				return n.value;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		ChainingHashTable hashTable = new ChainingHashTable(3);

		hashTable.put(1, 100);			//index=1
		hashTable.put(4, 200);			//index=1
		hashTable.put(7, 300);			//index=1

		System.out.println(hashTable.get(4));
	}
}
