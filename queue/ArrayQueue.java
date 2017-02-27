package queue;

/**
 * An array based implementation of a queue
 * 
 * @author Elexie Munyeneh
 *
 * @param <T>
 *            the generic data type stored in the queue
 */
public class ArrayQueue<T> implements ArrayQueueADT<T> {
	private int cap; // maximum number of elements allowed
	private int frontIndex; // index of the first enqueued element,is initially
							// 0
	private int rearIndex; // index of the last enqueued element, is initially 0
	private int size; // number of elements in the queue, different from
						// capacity
	private T[] queue;

	public ArrayQueue(int cap) {
		this.frontIndex = 0;
		this.rearIndex = -1;
		// this.front = this.queue[frontIndex];
		// this.back = this.queue[rearIndex];
		this.cap = cap;
		this.size = 0;
		this.queue = (T[]) new Object[cap];
	}

	@Override
	public void enqueue(T data) throws IndexOutOfBoundsException {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Index is out of bounds: ",
					rearIndex + 1);
		} else {
			// resetting the rear index
			// System.out.println("data: "+data);

			// there are empty slots at the front of the array
			if (frontIndex != 0 && rearIndex == cap - 1) {
				// System.out.println("reset rear to 0. data: "+data);
				this.rearIndex = 0;
				this.queue[rearIndex] = data;
			} else {
				this.rearIndex++;
				this.queue[rearIndex] = data;
			}
			// System.out.println("enqueued: "+this.queue[rearIndex]+". rear index: "+rearIndex);
			this.size++;

		}

	}

	@Override
	public T dequeue() throws IllegalStateException {
		T dequeued = this.queue[0];
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty. Cannot dequeue.");
		} else {
			// resetting the frontIndex
			if (frontIndex == cap - 1 && !isFull() || frontIndex == cap - 1
					&& isFull()) {
				dequeued = this.queue[frontIndex];
				this.frontIndex = -1;
			} else {
				dequeued = this.queue[frontIndex];
			}
			this.frontIndex++;
			this.size--;
			return dequeued;
		}
	}

	@Override
	public T peekFront() {
		return this.queue[this.frontIndex];
	}

	@Override
	public T peekBack() {
		return this.queue[this.rearIndex];
	}

	@Override
	public boolean isFull() {
		return this.size == this.cap;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int getCap() {
		return this.cap;
	}

	public int getFrontIndex() {
		return this.frontIndex;
	}

	public int getRearIndex() {
		return this.rearIndex;
	}

	public int getSize() {
		return this.size;
	}

	public T[] getQueue() {
		return this.queue;
	}

	/**
	 * prints from first enqueued to last enqueued. see documentation sheet for
	 * a more detailed explanation
	 */
	public String toString() {
		String output = "";
		if (!isEmpty()) {

			// a queue that contains only 1 element or a non circular queue
			if (frontIndex == rearIndex) {
				output = "" + this.queue[rearIndex];
				// ^convert the generic data to a String
				if (frontIndex == rearIndex || !(rearIndex < frontIndex)) {
					for (int x = frontIndex; x < size; x++) {
						output += "" + this.queue[x] + "\n";
					}
				}
			} else {
				// a circular queue
				if (rearIndex < frontIndex) {
					for (int x = frontIndex, limit = size; x < limit; x++) {
						output += "" + this.queue[x] + "\n";

						// if x reaches the end of the array
						if (x == cap - 1) {
							x = -1; // redirect the loop to the front of the
									// array
							// ^resetting x to 0 does not work because when the
							// function
							// returns to the top of the loop, x will be
							// incremented to 1, thus skipping
							// the 0th element
							limit = frontIndex - (cap - size); // see
																// documentation
						}
					}

				}
				// a non circular queue
				else {
					for (int x = frontIndex; x < size; x++) {
						output += "" + this.queue[x] + "\n";
					}
				}

			}

		}
		return output.trim();
	}

}
