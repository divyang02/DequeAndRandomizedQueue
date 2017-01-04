package queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first, last;
	
	
	private int N = 0;
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	public Deque() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		if (size() == 0) {
			first.previous = null;
			N++;
		} else {
			oldFirst.previous = first;
			first.previous = null;
			N++;
		}
		if (size() == 1) {
			last = first;
		}
	}
	
	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (size() == 0) {
			last.previous = oldLast;
			N++;
		} else {
			oldLast.next = last;
			last.previous = oldLast;
			N++;
		}
		if (size() == 1) {
			first = last;
		}
	}
	
	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = first.item;
		first = first.next;
		if (size() == 1) {
			N--;
		} else {
			first.previous = null;
			N--;
		}
		if (size() == 0) last = first;
		return item;
	}
	
	public Item removeLast() { 
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = last.item;
		last = last.previous;
		if (size() == 1) {
			N--;
		} else {
			last.next = null;
			N--;
		}
		if (size() == 0) first = last;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} 
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
