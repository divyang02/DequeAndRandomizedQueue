package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int tail;
	private Item[] i;
	private int N;
	
	public RandomizedQueue() {
		i = (Item[]) new Object[1];
		tail = 0;
		N = 0;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();		
		}
		if (tail == i.length) {
			resize(2 * i.length);
		}
		i[tail++] = item;
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int n = StdRandom.uniform(tail);
		Item temp = i[n];
		i[n] = i[--tail];
		i[tail] = null;
		N--;
		if(size() > 0 && size() == i.length/4) {
			resize(i.length/2);
		}
		return temp;
	}
	
	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return i[StdRandom.uniform(tail)];
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private int j = 0;
		
		public boolean hasNext() {
			return j != tail;
		}
		
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} 
			Item item = i[j];
			j++;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int j = 0; j < tail; j++) {
			copy[j] = i[j];
		}
		i = copy;
	}
	
	public static void main(String[] args) {
	   
	}
	
}
