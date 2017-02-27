package queue;

/**
 * This class runs basic tests on the queue see the junit file for more
 * 
 * @author Elexie
 *
 */
public class Main {

	public static void main(String[] args) throws IndexOutOfBoundsException,
			IllegalStateException {
		int cap = 4;
		ArrayQueue<String> aq = new ArrayQueue<>(cap);
		aq.enqueue("A");
		aq.enqueue("B");
		aq.enqueue("C");
		aq.enqueue("D");
		System.out.println("enqued a,b,c,d");

		System.out.println(aq);
		System.out.println("size:" + aq.getSize());
		System.out.println("rear index: " + aq.getRearIndex());
		System.out.println("frontIndex: " + aq.getFrontIndex());

		// dequeue a,b,c
		for (int x = 0; x < aq.getCap() - 1; x++) {
			aq.dequeue();
		}
		System.out.println("\ndequed a,b,c");
		System.out.println("size: " + aq.getSize());
		System.out.println("rearIndex: " + aq.getRearIndex());
		System.out.println("front index: " + aq.getFrontIndex());
		System.out.println(aq);

		aq.enqueue("1");
		aq.enqueue("2");
		aq.enqueue("3");
		System.out.println("\nenqueued 1,2,3");
		System.out.println("size: " + aq.getSize());

		System.out.println(aq);
		System.out.println("rearIndex: " + aq.getRearIndex());
		System.out.println("front index: " + aq.getFrontIndex());
		
		//dequeue d
		aq.dequeue();
		System.out.println("\ndequed d");
		System.out.println(aq);
		System.out.println("rearIndex: " + aq.getRearIndex());
		System.out.println("front index: " + aq.getFrontIndex());
		
		//enqueue 4
		aq.enqueue("4");
		System.out.println("\nenqueued 4");
		System.out.println(aq);
		System.out.println("rearIndex: " + aq.getRearIndex());
		System.out.println("front index: " + aq.getFrontIndex());
		
		//an arrayQueue of objects
		ArrayQueue<Object> a = new ArrayQueue<>(cap);
		a.enqueue("S");
		a.enqueue("P");
		a.enqueue(3);
		a.enqueue(4);
		System.out.println("\nAn arrayQueue of objects");
		System.out.println(a);
	}

}
