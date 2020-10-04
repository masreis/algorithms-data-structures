package net.ads.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListVsArrayList {
	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add(3);
		al.add(2);
		al.add(1);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(6);
		Iterator iter1 = al.iterator();
		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}

		LinkedList ll = new LinkedList();
		ll.add(3);
		ll.add(2);
		ll.add(1);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(6);
		Iterator iter2 = al.iterator();
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}

	}
}
