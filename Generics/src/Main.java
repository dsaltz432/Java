// Daniel Saltz
// Lab 1 parts 1-5

public class Main {

	public static void main(String[] args) {
		System.out.println("Beginning Tests\n");
		
		Integer [] intArray = {1, 2, 3, 4, 5 };
		Double [] doubArray = {1.1, 2.2, 3.3, 4.4};
		Character [] charArray = {'H','E','L', 'L', 'O' };
		String [] strArray = {"once","upon","a","time"};
//		printarray(intArray);
//		printarray(doubArray);
//		printarray(charArray);
//		printarray(strArray);
		
		System.out.println("max Integer is: " + getMax(intArray));
		System.out.println("max Double is: " + getMax(doubArray));
		System.out.println("max Character is: " + getMax(charArray));
		System.out.println("max String is: " + getMax(strArray));
		
	}
	
// part 5
	public static <Array extends Comparable<? super Array>> Array getMax(Array[] a) {
		
		Array max;
		if (a != null)
			max = a[0];
		else
			return null;

		for (int i = 0; i < a.length; i++) {
			if (a[i].compareTo(max) > 0)
				max = a[i];
		}
		return max;
	}
	
	// part 4
	// compile warnings: 
	// Comparable is a raw type. References to generic type 
	// Comparable<T> should be parameterized
//	public static Comparable getMax(Comparable[] a) {
//		
//		Comparable max;
//		if (a != null)
//			max = a[0];
//		else
//			return null;
//
//		for (int i = 0; i < a.length; i++) {
//			if (a[i].compareTo(max) > 0)
//				max = a[i];
//		}
//		return max;
//	}
	
// part 3
//	private static <Array> void printarray(Array[] anyArray) {
//		for (Array a : anyArray)
//			System.out.println(a);	
//	}
	
// part 2
//	private static void printarray(Integer[] intArray) {
//		for (Integer i : intArray)
//			System.out.println(i);
//	}
//
//	private static void printarray(Double[] doubArray) {
//		for (Double d : doubArray)
//			System.out.println(d);
//	}
//
//	private static void printarray(Character[] charArray) {
//		for (Character c : charArray)
//			System.out.println(c);	
//	}
//
//	private static void printarray(String[] strArray) {
//		for (String s : strArray)
//			System.out.println(s);
//	}
//
// part 1
//	private static void printarray(Object[] objArray) {
//		for (Object obj : objArray)
//			System.out.println(obj);
//	}
}
