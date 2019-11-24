package b;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/**
 * Dynamic Array class (based on java.util.ArrayList) for /r/JavaExamples - for
 * tutorial purposes -
 * 
 * @author /u/Philboyd_Studge on 11/18/2015.
 */
public class App8<E> implements Iterable<E>, RandomAccess {

	private static final int INITIAL_CAPACITY = 10;

	private int size;
	private int capacity = INITIAL_CAPACITY;

	private Object[] array;

	/**
	 * Construct dynamic array with default initial capacity
	 */
	public App8() {
		array = new Object[INITIAL_CAPACITY];
	}

	/**
	 * Construct dynamic array with given capacity
	 * 
	 * @param capacity integer capacity greater than zero
	 */
	public App8(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Illegal initial capacity : " + capacity);
		}
		this.capacity = capacity;
		array = new Object[capacity];
	}

	/**
	 * Construct dynamic array from given array
	 * 
	 * @param inputArray array of type E
	 */
	public App8(E[] inputArray) {
		this(inputArray.length + INITIAL_CAPACITY);
		for (int i = 0; i < inputArray.length; i++) {
			array[i] = inputArray[i];
			size++;
		}
	}

	/**
	 * Add element to the end of the list runs in amortized constant time
	 * 
	 * @param element Element of type E to add to list.
	 */
	public void add(E element) {
		sizeCheck();
		array[size++] = element;
	}

	/**
	 * Add element at specific index, from 0 to size moves all elements after index
	 * up one
	 * 
	 * @param element Element to add of type E
	 * @param index   integer index
	 */
	public void add(E element, int index) {
		if (index == size) {
			add(element);
		} else {
			rangeCheck(index);
			sizeCheck();
			System.arraycopy(array, index, array, index + 1, size - index);
			array[index] = element;
			size++;

		}
	}

	/**
	 * @return size of list.
	 */
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Get element at specific index
	 * 
	 * @param index index to get
	 * @return Element E
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		rangeCheck(index);
		return (E) array[index];
	}

	/**
	 * Set element at specific index
	 * 
	 * @param element Element to set of type E
	 * @param index   index to set
	 * @return previous value at that index
	 */
	public E set(E element, int index) {
		rangeCheck(index);
		E value = get(index);
		array[index] = element;
		return value;
	}

	/**
	 * remove item at specific index
	 * 
	 * @param index of item to remove
	 * @return element being removed
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		rangeCheck(index);
		E value = (E) array[index];
		int numberToMove = size - index - 1;
		if (numberToMove > 0) {
			System.arraycopy(array, index + 1, array, index, numberToMove);
		}
		array[--size] = null;
		return value;
	}

	/**
	 * remove specific Object from list, if it exists
	 * 
	 * @param o object to remove
	 * @return true if exists
	 */
	public boolean remove(Object o) {
		int found = this.indexOf(o);
		if (found < 0)
			return false;
		this.remove(found);
		return true;
	}

	/**
	 * indexOf runs in linear time. If passed object is null, will return the first
	 * null element found.
	 * 
	 * @param obj object to search for, must have valid equals method
	 * @return index of object or -1 if not found
	 */
	public int indexOf(Object obj) {
		if (obj == null) {
			for (int i = 0; i < size; i++) {
				if (array[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (obj.equals(array[i]))
					return i;
			}
		}
		return -1;
	}

	/**
	 * contains runs in linear time
	 * 
	 * @param obj Object to search for, must have valid equals method
	 * @return true if is in the list
	 */
	public boolean contains(Object obj) {
		return indexOf(obj) >= 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int cursor = 0;

			@Override
			@SuppressWarnings("unchecked")
			public E next() {
				if (!hasNext()) {
					throw new IllegalArgumentException("No more elements available.");
				}
				E value = (E) array[cursor];
				cursor++;
				return value;
			}

			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public void remove() {
				rangeCheck(--cursor);
				App8.this.remove(cursor);
			}
		};
	}

	/**
	 * clear all elements from the list and return size to 0 retains current
	 * capacity
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}

	/**
	 * reset array to size
	 */
	public void trimToSize() {
		if (size < array.length) {
			array = Arrays.copyOf(array, size);
			capacity = size;
		}
	}

	/**
	 * return array of Objects
	 * 
	 * @return array of Objects
	 */
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	/**
	 * return array of type T
	 * 
	 * @param a   empty array of type T
	 * @param <T> T
	 * @return array of type T
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		return (T[]) Arrays.copyOf(array, size, a.getClass());
	}

	private void sizeCheck() {
		if (size + 1 >= capacity) {
			grow();
		}
	}

	private void grow() {
		capacity += (capacity * 3) / 2;
		array = Arrays.copyOf(array, capacity);
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index : " + index);
		}
	}

	public static void main(String[] args) {
		App8<Integer> poop = new App8<>();
		assert poop.isEmpty() : "Not empty";
		assert poop.size() == 0 : "Not zero";

		poop.add(1);
		poop.add(23);
		poop.add(144);
		System.out.println(poop.contains(144));
		System.out.println(poop.contains(20));
		System.out.println(poop.get(2));
		System.out.println(poop.size());
		poop.set(100, 2);
		poop.remove(1);
		System.out.println(poop.get(0));

		poop.forEach(System.out::println);

		poop.clear();
		assert poop.isEmpty() : "Not empty";

		String[] test = { "Andy", "Ron", "Donna", "Leslie", "April", "Ben", "Jerry", "Tom", "Ann", "Chris" };
		App8<String> strings = new App8<>(test);

		Iterator<String> iter = strings.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			if (s.equals("Jerry")) {
				iter.remove();
			} else {
				System.out.println(s);
			}
		}

		for (String each : strings) {
			System.out.println(each);
		}
	}
}