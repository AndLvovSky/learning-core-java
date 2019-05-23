public class MyArrayListTest {
	public static void print(MyArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print((Integer)list.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add(1);
		print(list);
		list.add(2);
		print(list);
		list.add(1, 3);
		print(list);
		list.addAll(new Integer[]{4, 5});
		print(list);
		list.addAll(2, new Integer[]{6, 7});
		print(list);
		list.remove(3);
		print(list);
		list.set(1, 8);
		print(list);
		System.out.println(list.size() == 6);
		System.out.println((Integer)list.get(2) == 6);
		list.set(14, 9);
		print(list);
		System.out.println(list.size() == 15);
	}
}