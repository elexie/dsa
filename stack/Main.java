package stack;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws EmptyCollectionException,
			FileNotFoundException, NullPointerException {
		StackList<String> sl = new StackList<>();
		System.out.println("push 4 elements to the stack list");
		sl.push("Agnes");
		sl.push("Jacob");
		sl.push("David");
		sl.push("Jeremy");
		System.out.println("Print the Stack (from most to least recent)\n"+sl+"\n");
		
		System.out.println("bottom: " + sl.getBottom());
		System.out.println("Top: " + sl.getTop());
		System.out.println("size: " + sl.getSize() + "\n");

		System.out.println("peek: " + sl.peek()+"\n");

		System.out.println("pop all elements of the stack");
		int size=sl.getSize();
		//note: do not change the condition 'x<4' to x<sl.getSize()'.
		//as elements are removed from the loop, the size will change
		for (int x = 0; x < size; x++) {
			System.out.println("pop: " + sl.pop());
		}
		System.out.println("\nnew stack size: "+sl.getSize());
		System.out.println("stack.isEmpty(): "+sl.isEmpty());
		
		
		
		System.out.println("\n\u2764 see the junit test for more \u2764");
	
	}
}
