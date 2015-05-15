package pucrs.alpro2.listas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListSimpleLinkedEx9Test {

	@Test
	public void testSimple() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		for (int i = 10; i <= 100; i += 10) {
			lista.add(i);
		}
		
		// 0   1   2    3   4   5   6   7   8    9
		// 10 20 30 40 50 60 70 80 90 100
		//
		// 30 40 50
		ListSimpleLinked<Integer> actual = lista.subList(2, 5);
		assertTrue(30 == actual.get(0));
		assertTrue(40 == actual.get(1));
		assertTrue(50 == actual.get(2));
		assertEquals(3, actual.size());

	}

	@Test
	public void testEmpty() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		for (int i = 10; i <= 100; i += 10) {
			lista.add(i);
		}
		
		// 0   1   2    3   4   5   6   7   8    9
		// 10 20 30 40 50 60 70 80 90 100
		ListSimpleLinked<Integer> actual = lista.subList(2, 2);
		assertEquals(0, actual.size());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testOutOfBounds() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		for (int i = 10; i <= 100; i += 10) {
			lista.add(i);
		}
		
		ListSimpleLinked<Integer> actual = lista.subList(-2, 200);
	}
}
