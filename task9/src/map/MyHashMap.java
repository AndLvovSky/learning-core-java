package map;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

public class MyHashMap implements MyMap {

	public class SimpleEntry implements MyMap.Entry {

		private Object key;

		private Object value;

		public SimpleEntry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object o) {
			if (!(o instanceof SimpleEntry)) {
				return false;
			}
			SimpleEntry se = (SimpleEntry)o;
			return key.equals(se.key) 
				&& value.equals(se.value);
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public int hashCode() {
			return key.hashCode();
		}

		public void setValue(Object value) {
			this.value = value;
		}

	}

	private class MapIterator implements Iterator {

		private MyHashMap map;

		private int i;

		private int j;

		private int n;

		public MapIterator(MyHashMap map) {
			this.map = map;
			i = j = n = 0;
		}

		public boolean hasNext() {
			return n >= map.size;
		}

		public SimpleEntry next() {
			if (n >= map.size) {
				throw new NoSuchElementException();
			}
			SimpleEntry res;
			if (j < map.entries[i].size()) {
				res = map.entries[i].get(j);
				j++;
			} else {
				i++;
				j = 0;
				while (map.entries[i].size() == 0) {
					i++;
				}
				res = map.entries[i].get(0);
			}
			n++;
			return res;
		}

	}

	private int capacity = 16;

	private float loadFactor = 0.75f;

	private LinkedList<SimpleEntry>[] entries;

	private int size = 0;

	public MyHashMap() {
		entries = new LinkedList[capacity];
		for (int i = 0; i < capacity; i++) {
			entries[i] = new LinkedList<SimpleEntry>();
		}
	}

	public MyHashMap(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException(
				"initialCapacity cannot be negative");
		}
		capacity = initialCapacity;
		entries = new LinkedList[capacity];
		for (int i = 0; i < capacity; i++) {
			entries[i] = new LinkedList<SimpleEntry>();
		}
		loadFactor = 0.75f;
	}

	public MyHashMap(int initialCapacity, float loadFactor) {
		this(initialCapacity);
		if (loadFactor <= 0) {
			throw new IllegalArgumentException(
				"loadFactor must be positive");
		}
		this.loadFactor = loadFactor;
	}

	public void clear() {
		entries = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public Iterator entryIterator() {
		return new MapIterator(this);
	}

	public Object get(Object key) {
		for (int i = 0; i < capacity; i++) {
			Iterator it = entries[i].iterator();
			while (it.hasNext()) {
				SimpleEntry e = (SimpleEntry)it.next();
				if (e.key == key) {
					return e.value;
				}
			}
		}
		return null;
}

	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	public boolean containsValue(Object value) {
		for (int i = 0; i < capacity; i++) {
			Iterator it = entries[i].iterator();
			while (it.hasNext()) {
				SimpleEntry e = (SimpleEntry)it.next();
				if (e.value == value) {
					return true;
				}
			}
		}
		return false;
	}

	public void put(Object key, Object value) {
		if (size >= capacity * loadFactor) {
			enlarge();
		}
		int i = key.hashCode() % capacity;
		entries[i].add(new SimpleEntry(key, value));
	}

	public void remove(Object key) {
		for (int i = 0; i < capacity; i++) {
			ListIterator it = (ListIterator)entries[i].iterator();
			while (it.hasNext()) {
				SimpleEntry e = (SimpleEntry)it.next();
				if (e.key == key) {
					it.remove();
					return;
				}
			}
		}
	}

	private void enlarge() {
		LinkedList<SimpleEntry> copy = new LinkedList();
		MapIterator it = (MapIterator)entryIterator();
		while (it.hasNext()) {
			copy.add(it.next());
		}
		capacity *= 2;
		entries = new LinkedList[capacity];
		for (int i = 0; i < capacity; i++) {
			entries[i] = new LinkedList<SimpleEntry>();
		}
		Iterator itc = copy.iterator();
		while (itc.hasNext()) {
			SimpleEntry cur = (SimpleEntry)itc.next();
			int i = cur.hashCode() % capacity;
			entries[i].add(cur); 
		}
	}

}