package queue;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String[] args) {
		RandomizedQueue<String> queue = new RandomizedQueue<>();
		int k = Integer.parseInt(args[0]);
		String s = StdIn.readLine();
		while (s != null) {
			s = s.trim();
			String[] arr = s.split("\\ +");
			for (int i = 0; i < arr.length; i++) {
				if (queue.size() > k) queue.dequeue();
				queue.enqueue(arr[i]);
			}
			s = StdIn.readLine();
		}
		
		for (int i = 0; i < k; i++) {
			System.out.println(queue.dequeue());
		}
		
	}

}
