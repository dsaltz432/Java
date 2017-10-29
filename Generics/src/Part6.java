import java.util.Comparator;

// Daniel Saltz
// Lab1 Part 6


public class Part6 {
	
	public static void main(String []args)
	{		
		System.out.println("Beginning Tests\n");
		Character [] charArray = {'H','E','L','W', 'L', 'O'};
		System.out.println(findMax(charArray, new CaseInsensitiveCompare()));
		
	}
	
// code taken from figure 1.18 of the textbook	
	public static <AnyType> AnyType findMax(AnyType [] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex = 0;
		
		for (int i = 1; i < arr.length; i++)
		{
			if (cmp.compare(arr[i], arr[maxIndex]) > 0)
				maxIndex = i;
		}
		return arr[maxIndex];
	}	
}

class CaseInsensitiveCompare implements Comparator<Character> {
	public int compare(Character lhs, Character rhs )
	{
		return lhs.compareTo(rhs); }
	}