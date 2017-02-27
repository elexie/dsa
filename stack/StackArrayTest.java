package stack;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class StackArrayTest {
	String filePath, line, countries;
	int size;
	StackArray<String> stringStack;
	StackArray<Integer> intStack;
	StackArray<Object> objectStack;

	Scanner s;

	@Test
	public void testPush() throws FileNotFoundException {

		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//africanCountries.txt";
		String[] countries = new String[61];

		int x = 0;
		line = "";
		s = new Scanner(new File(filePath));

		// add all countries from africanCountries.txt
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			countries[x] = line;
			x++;
		}
		stringStack = new StackArray<>(countries);
		for (int i = 0; i < countries.length; i++) {
			stringStack.push(countries[i]);
		}

		// add all names from names.txt
		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//names.txt";
		s = new Scanner(new File(filePath));
		line = "";
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			stringStack.push(line);
		}
		s.close();
	}

	@Test
	public void testPeek() throws EmptyCollectionException,
			FileNotFoundException {
		stringStack = new StackArray<>();

		// add all countries
		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//africanCountries.txt";

		s = new Scanner(new File(filePath));
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			stringStack.push(line);
		}

		size = stringStack.getSize();
		for (int x = 0; x < size; x++) {
			assertEquals(stringStack.peek(), stringStack.pop());
		}

	}

	@Test
	public void testPop() throws EmptyCollectionException,
			FileNotFoundException {
		stringStack = new StackArray<>();
		// add all countries to the file
		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//africanCountries.txt";
		s = new Scanner(new File(filePath));
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			stringStack.push(line);
		}
		// file contains 61 countries
		assertEquals(stringStack.getSize(), 61);

		// pop all countries
		size = stringStack.getSize();
		for (int x = 0; x < size; x++) {
			stringStack.pop();
		}
		// check size
		assertEquals(0, stringStack.getSize());

	}

	@Test
	public void testReverseStack() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() throws EmptyCollectionException,
			FileNotFoundException {
		stringStack = new StackArray<String>();
		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//africanCountries.txt";
		s = new Scanner(new File(filePath));

		// push all countries to the stack
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			stringStack.push(line);
		}

		// check that isEmpty() is false
		assertTrue(!stringStack.isEmpty());

		int size = stringStack.getSize();
		int x = 0;
		while (x < size) {
			stringStack.pop();
			x++;
		}

		// check that isEmpty() is true
		assertTrue(stringStack.isEmpty());
	}

	@Test
	public void testCondense() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoubleCapacity() {
		stringStack = new StackArray<>();
		assertEquals(stringStack.getCapacity(), 0);

		stringStack.push("Azerbaijan");
		assertEquals(stringStack.getCapacity(), 2);

		stringStack.push("Cape Verde");
		assertEquals(stringStack.getCapacity(), 2);

		stringStack.push("Cayman Islands");
		assertEquals(stringStack.getCapacity(), 4);
	}

	@Test
	public void testArrayStackEArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testArrayStack() {

	}

	@Test
	public void testGetCapacity() throws EmptyCollectionException,
			FileNotFoundException {
		stringStack = new StackArray<>();

		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//africanCountries.txt";
		s = new Scanner(new File(filePath));

		// push all countries to the stack
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			stringStack.push(line);
		}

		int size = stringStack.getSize();

		// clear the stack
		for (int x = 0; x < size; x++) {
			stringStack.pop();
		}

		//
		assertTrue(stringStack.isEmpty());

	}

	@Test
	public void testToString() throws EmptyCollectionException,
			FileNotFoundException {
		countries = "";
		filePath = "C://Users//Elexie//newWorkspace//AlgorithmsStudy//src//stack//africanCountries.txt";
		stringStack = new StackArray<>();
		s = new Scanner(new File(filePath));
		
		// add all countries to the file
		while (s.hasNextLine()) {
			line = s.nextLine().trim();
			countries += line + "\n";
			stringStack.push(line);
		}
		
		//make sure the string matches
		assertEquals(countries.trim(), stringStack.toString());
	}

}
