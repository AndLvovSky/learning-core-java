package map;

import java.util.Iterator;

public interface MyMap {

	public interface Entry {

		boolean equals(Object o);

		Object getKey();

		Object getValue();

		int hashCode();

		void setValue(Object value);

	}

	void clear();

	boolean containsKey(Object key);

	boolean containsValue(Object value);

	Object get(Object key);

	boolean isEmpty();

	void put(Object key, Object value);

	void remove(Object key);

	int size();

	Iterator entryIterator();

}