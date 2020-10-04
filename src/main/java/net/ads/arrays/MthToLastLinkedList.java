package net.ads.arrays;

public class MthToLastLinkedList {

	private Node head = null;

	class Node {
		String value;
		Node next;

		@Override
		public String toString() {
			return value;
		}
	}

	public void add(String value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = null;
		//
		if (head == null) {
			head = newNode;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}

	public void display() {
		if (head == null) {
			throw new RuntimeException("Empty");
		}
		Node cur = head;
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		MthToLastLinkedList list = new MthToLastLinkedList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.display();
		System.out.println(list.mthToLast(4));
		System.out.println(list.mthToLast(7));
		System.out.println(list.mthToLast(8));
		System.out.println(list.mthToLast(1));
		System.out.println(list.mthToLast(3));
	}

	private String mthToLast(int m) {
		int n = 0;
		Node result = null;
		Node curr = head;
		while (curr != null) {
			curr = curr.next;
			if (n == m) {
				result = head;
			} else if (n > m) {
				result = result.next;
			}
			n++;
		}
		if (result == null) {
			return null;
		}
		return result.toString();
	}

}
