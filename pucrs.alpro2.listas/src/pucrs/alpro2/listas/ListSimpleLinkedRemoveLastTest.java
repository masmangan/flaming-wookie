package pucrs.alpro2.listas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListSimpleLinkedRemoveLastTest {

	@Test
	public void testNotFound() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		for (int i = 10; i <= 60; i += 10) {
			lista.add(i);
		}
		// 0   1   2    3   4   5   
		// 10 20 30 40 50 60 
		boolean actual = lista.removeLast(200);
		assertEquals(false, actual);
		assertEquals(6, lista.size());
		assertTrue(10 == lista.get(0));
		assertTrue(20 == lista.get(1));
		assertTrue(30 == lista.get(2));
		assertTrue(40 == lista.get(3));
		assertTrue(50 == lista.get(4));
		assertTrue(60 == lista.get(5));
		
	}	
	
	@Test
	public void testTwins() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		for (int i = 10; i <= 60; i += 10) {
			lista.add(i);
		}
		lista.set(3, 20);
		// 0   1   2    3   4   5   
		// 10 20 30 20 50 60 
		boolean actual = lista.removeLast(20);
		assertEquals(true, actual);
		assertEquals(5, lista.size());
		assertTrue(10 == lista.get(0));
		assertTrue(20 == lista.get(1));
		assertTrue(30 == lista.get(2));
		assertTrue(50 == lista.get(3));
		assertTrue(60 == lista.get(4));
		
	}

	@Test
	public void testSingle() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		for (int i = 10; i <= 60; i += 10) {
			lista.add(i);
		}
		// 0   1   2    3   4   5   
		// 10 20 30 40 50 60 
		boolean actual = lista.removeLast(20);
		assertEquals(true, actual);
		assertEquals(5, lista.size());
		assertTrue(10 == lista.get(0));
		assertTrue(30 == lista.get(1));
		assertTrue(40 == lista.get(2));
		assertTrue(50 == lista.get(3));
		assertTrue(60 == lista.get(4));
		
		
	}

	@Test
	public void testEmpty() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		boolean actual = lista.removeLast(20);
		assertEquals(false, actual);
		assertTrue(lista.isEmpty());
	}
	
	@Test
	public void testSingleton() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		lista.add(20);
		boolean actual = lista.removeLast(20);
		assertEquals(true, actual);
		assertTrue(lista.isEmpty());
	}

	@Test
	public void testTailTwins() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		Integer a = 20;
		Integer b = 20;
		lista.add(a);
		lista.add(b);
		boolean actual = lista.removeLast(20);
		assertEquals(true, actual);
		assertEquals(1, lista.size());
		assertTrue(a.hashCode() == lista.get(0).hashCode());
	}	
	
	@Test
	public void testHead() {
		ListSimpleLinked<Integer> lista = new ListSimpleLinked<>();
		lista.add(20);
		lista.add(30);
		boolean actual = lista.removeLast(20);
		assertEquals(true, actual);
		assertEquals(1, lista.size());
		assertTrue(30 == lista.get(0));
	}	
}
