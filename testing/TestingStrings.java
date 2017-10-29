/* 

	****** Popular String Methods: *******

	length() - returns the length of the string
	charAt(index) - returns the char for that index of the string
	equals() - tests to see if two strings have identical content
	equalsIgnoreCase() - checks for equality, ignoring case sensitivity
	compareTo() - returns positive if the string that invokes the method is greater than 
					the string that is passed in
	s1.regionMatches(0,s2,0,4) -checks equality of two strings in a specific region 
	s1.startsWith("st",2) - returns true if s1 starts with "st" at position 2
	s1.endsWith("ings") - returns true if s1 ends with "ings"
	indexOf('c') - returns the first index of a character: returns -1 if can't find the character
	indexOf('c',2) - returns the first index of a character, starting at the 3rd index
	lastIndexOf("def") - returns the last index of a string
	lastIndexOf("def",1) - returns the last index of a string, starting at the 2nd index
	substring(4) - returns a new String object starting from the 5th index
	substring(4,7) - returns a new String object from the 5th-8th index
	concat() - concatenates 2 strings, and returns new String object
	s1.replaces("t","td") - replaces every "t" with "td" 
	toUpperCase()
	toLowerCase()
	trim() - removes leading or trailing white-space
	toCharArray() - creates new char array, each character of the string being an element of the array
	valueOf() - 7 different valueOf() methods: one for each primitive type
			  - can take any primitive type, and return a String of that value
			  - can also take any random object, because all objects can be converted to Strings using toString()
	valueOf(charArray,3,3) - can create a new String with a portion of charArray
*/

public class TestingStrings{

	public static void main(String[] args)
	{
		char[] charArray = {'1','2','3','4','5'};
		String s = new String(charArray);


		/* testing String methods length, charAt, getChars */
		System.out.println("\nTesting length, charAt, getChar methods");
		System.out.println(s.length()); // prints 5
		System.out.println(s.charAt(0)); // prints 1

		char[] c = new char[5];
		String s1 = "hello there";

		// 1st arg: start getting characters at the 0th index
		// 2nd arg: copy 5 characters
		// 3rd arg: the char array to copy to
		// 4th arg: start copying into the char array at the 0th index
		s1.getChars(0,3,c,0);

		for (char ch : c)
			System.out.print(ch);
		System.out.println(); // prints "hel"


		/* Testing string equality */
		System.out.println("\nTesting string equality");
		String s2 = "hello";
		System.out.println(s1=="hello"); // false, not the same object
		System.out.println(s2.equals("hello")); // true, same content
		String s3 = s2; // refer to same object in memory
		System.out.println(s2.equals(s3)); // true


	}
}