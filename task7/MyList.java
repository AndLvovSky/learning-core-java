public interface MyList {
	void add(Object e);

	void add(int index, Object element);

	void addAll(Object[] c);

	void addAll(int index, Object[] c);

	Object get(int index);

	Object remove(int index);

	void set(int index, Object element);

	int indexOf(Object e);

	int size();

	Object[] toArray();
}
