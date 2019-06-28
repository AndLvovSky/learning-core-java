package test;

import map.*;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashMapTest {
	
	@Test
	public void smallTest() {
		MyMap map = new MyHashMap();
		map.put("abc", 1);
		map.put("def", 1000000000);
		map.put("ghtip", 43);
		assertEquals(map.size(), 3);
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("def"));
		assertFalse(map.containsKey("try"));
		assertTrue(map.containsValue(43));
		assertFalse(map.containsValue(7));
		assertEquals((int)map.get("abc"), 1);
		assertNull(map.get("rerw"));
		map.remove("def");
		assertFalse(map.containsKey("def"));
		map.clear();
		assertEquals(map.size(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void incorrectCapacity() {
		MyMap map = new MyHashMap(-2, 0.5f);
	}

	@Test(expected = IllegalArgumentException.class)
	public void incorrectLoadFactor() {
		MyMap map = new MyHashMap(55, 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorOveruse() {
		MyMap map = new MyHashMap();
		map.put("abc", 1);
		map.put("def", 1000000000);
		Iterator it = map.entryIterator();
		while (it.hasNext()) {
			it.next();
		}
		it.next();
	}

	@Test(timeout = 1000)
	public void bigTest() {
		int c = 100000;
		MyMap myMap = new MyHashMap();
		TreeMap map = new TreeMap();
		Random rand = new Random();
		Iterator it;
		for (int i = 0; i < c; i++) {
			int key = rand.nextInt();
			int value = rand.nextInt();
			map.put(key, value);
		}
		it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			myMap.put(entry.getKey(), entry.getValue());
		}
		it = myMap.entryIterator();
		while (it.hasNext()) {
			MyHashMap.Entry entry = (MyHashMap.Entry)it.next();
			assertFalse(!map.containsKey(entry.getKey()) ||
				!map.get(entry.getKey()).equals(entry.getValue()));
		}
		it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			myMap.remove((int)entry.getKey());
		}
		assertEquals(myMap.size(), 0);
	}

}
