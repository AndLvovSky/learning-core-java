package test;

import map.*;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyHashMapTest {

	private static void print(MyHashMap map) {
		Iterator it = map.entryIterator();
		while (it.hasNext()) {
			MyHashMap.SimpleEntry e = (MyHashMap.SimpleEntry)it.next(); 
			System.out.println((String)e.getKey() + " : " + (int)e.getValue());
		}
	}
	
	private static void smallTest() {
		MyMap map = new MyHashMap();
		map.put("abc", 1);
		map.put("def", 1000000000);
		map.put("ghtip", 43);
		print((MyHashMap)map);
		System.out.println(map.size() == 3);
		System.out.println(!map.isEmpty());
		System.out.println(map.containsKey("def"));
		System.out.println(!map.containsKey("try"));
		System.out.println(map.containsValue(43));
		System.out.println(!map.containsValue(7));
		System.out.println((int)map.get("abc") == 1);
		System.out.println(map.get("rerw") == null);
		map.remove("def");
		print((MyHashMap)map);
		map.clear();
		System.out.println(map.size() == 0);
	}

	public static void extremeTest() {
		MyMap map;
		boolean flag;
		flag = false;
		try {
			map = new MyHashMap(-2, 0.5f);
		} catch(IllegalArgumentException ex) {
			flag = true;
		}
		System.out.println(flag);
		flag = false;
		try {
			map = new MyHashMap(55, 0);
		} catch(IllegalArgumentException ex) {
			flag = true;
		}
		System.out.println(flag);
		flag = false;
		try {
			map = new MyHashMap();
			map.put("abc", 1);
			map.put("def", 1000000000);
			Iterator it = map.entryIterator();
			while (it.hasNext()) {
				it.next();
			}
			it.next();
		} catch(NoSuchElementException ex) {
			flag = true;
		}
		System.out.println(flag);
	}

	private static boolean bigTest(int c) {
		long totalTime = 0, startTime, endTime;
		MyMap myMap = new MyHashMap();
		TreeMap map = new TreeMap();
		Random rand = new Random();
		Iterator it;
		for (int i = 0; i < c; i++) {
			int key = rand.nextInt();
			int value = rand.nextInt();
			map.put(key, value);
		}
		startTime = System.currentTimeMillis();
		it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			myMap.put(entry.getKey(), entry.getValue());
		}
		endTime = System.currentTimeMillis();
		totalTime += endTime - startTime;
		it = myMap.entryIterator();
		while (it.hasNext()) {
			MyHashMap.Entry entry = (MyHashMap.Entry)it.next();
			if (!map.containsKey(entry.getKey()) ||
				!map.get(entry.getKey()).equals(entry.getValue())) {
				return false;
			}
		}
		startTime = System.currentTimeMillis();
		it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			myMap.remove((int)entry.getKey());
		}
		endTime = System.currentTimeMillis();
		totalTime += endTime - startTime;
		if (myMap.size() != 0) {
			System.out.println(myMap.size());
			return false;
		}
		System.out.println(totalTime + " ms");
		return true;
	}

	public static void main(String[] args) {
		smallTest();
		extremeTest();
		System.out.println(bigTest(10000));
		System.out.println(bigTest(100000));
		System.out.println(bigTest(1000000));
	}

}
