package pucrs.alpro2.listas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListArrayTest {

	@Test
	public void testAddMiddle() {
		ListTAD<Integer> actuals = new ListArray<Integer>();
		actuals.add(10);
		actuals.add(30);
		actuals.add(1, 20);
		assertTrue(10 == actuals.get(0));
		assertTrue(20 == actuals.get(1));
		assertTrue(30 == actuals.get(2));
		assertTrue(3 == actuals.size());

	}

	@Test
	public void testAddFirst() {
		ListTAD<Integer> actuals = new ListArray<Integer>();
		actuals.add(20);
		actuals.add(30);
		actuals.add(0, 10);
		assertTrue(10 == actuals.get(0));
		assertTrue(20 == actuals.get(1));
		assertTrue(30 == actuals.get(2));
		assertTrue(3 == actuals.size());
	}

	@Test
	public void testAddLast() {
		ListTAD<Integer> actuals = new ListArray<Integer>();
		actuals.add(10);
		actuals.add(20);
		actuals.add(2, 30);
		assertTrue(10 == actuals.get(0));
		assertTrue(20 == actuals.get(1));
		assertTrue(30 == actuals.get(2));
		assertTrue(3 == actuals.size());		
	}

	@Test
	public void testRemoveMiddle() {
		ListTAD<Integer> actuals = new ListArray<Integer>();
		actuals.add(10);
		actuals.add(20);
		actuals.add(30);
		int v = actuals.removeAt(1);

		assertTrue(10 == actuals.get(0));
		assertTrue(30 == actuals.get(1));
		assertTrue(2 == actuals.size());
		assertEquals(20, v);
	}

	@Test
	public void testRemoveFirst() {
		ListTAD<Integer> actuals = new ListArray<Integer>();
		actuals.add(10);
		actuals.add(20);
		actuals.add(30);
		int v = actuals.removeAt(0);
		assertTrue(20 == actuals.get(0));
		assertTrue(30 == actuals.get(1));
		assertTrue(2 == actuals.size());
		assertEquals(10, v);

	}

	@Test
	public void testRemoveLast() {
		ListTAD<Integer> actuals = new ListArray<Integer>();
		actuals.add(10);
		actuals.add(20);
		actuals.add(30);
		int v = actuals.removeAt(2);

		assertTrue(10 == actuals.get(0));
		assertTrue(20 == actuals.get(1));
		assertTrue(2 == actuals.size());
		assertEquals(30, v);

	}

}
