package net.ads.arrays;

// TODO
public class NullOrCycleLinkedList {

	private Node head;

	class Node {
		int value;
		Node next;
	}

	public void add(int value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = null;
		if (head == null) {

		}
	}
}
