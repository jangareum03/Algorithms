package chatGPT.dataStructure.map;

import javax.swing.*;
import java.util.LinkedList;

/**
 * 해시 테이블 - 리사이징(확장)
 */
public class DynamicHashTable {

	static class Node {
		int key, value;

		Node( int key, int value ) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<Node>[] table;
	private int size = 0;

	public DynamicHashTable(int capacity) {
		table = new LinkedList[capacity];

		//초기화 진행(하지 않으면 모두 null로 초기화 됨)
		for( int i=0; i<capacity; i++ ) {
			table[i] = new LinkedList<>();
		}
	}

	private int hash(int key) {
		return Math.abs(key) % table.length;
	}

	public void put(int key, int value) {
		//0.75 이상인지 확인
		if( (double) size / table.length > 0.75 ) rehash();

		int index = hash(key);
		for(Node n : table[index]) {
			if( n.key == key ) n.value = value; return;
		}

		table[index].add( new Node(key, value) );
		size++;
	}

	private void rehash() {
		LinkedList<Node>[] oldList = table;
		table = new LinkedList[oldList.length * 2];

		for( int i=0; i<table.length; i++ ) {
			table[i] = new LinkedList<>();
		}
		size = 0;

		for(LinkedList<Node> nodes  : oldList ) {
			for(Node n : nodes ) {
				put(n.key, n.value);
			}
		}
	}

	public Integer get(int key) {
		int index = hash(key);

		for(Node n : table[index]) {
			if( n.key == key ) return n.value;
		}

		return null;
	}

	public static void main(String[] args) {
		DynamicHashTable ht = new DynamicHashTable(2);
		ht.put(1, 100);
		ht.put(2, 200);
		ht.put(3, 300); // load factor 초과 → 자동 확장
		System.out.println(ht.get(3)); // 300
	}
}
