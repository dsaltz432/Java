/*  This is a test class that explores various ways to format output  

**** Format specifiers: ****

byte, short, int, long: %d

float, double: 
	%f: decimal format: 

	%e or %E: exponential notation in lowercase or uppercase

char: %c or %C for uppercase
	-can't use %c with a string, becuase it has to be converted to a single character char

String or any object: %s or %S for uppercase

boolean: %b or %B for uppercase


**** Formatting field width: ****
System.out.printf("%3d\n",1234567);
- if the field width is not large enough, the data automatically right justifies

**** Formatting precisionh: ****
System.out.printf("%.3d\n",1234567); // rounds to 3 decimal places
-default precision is 6 decimal places
-always adds digit to the left of the decimal point

*/


public class FormattedOutput{

	public static void main(String args[])
	{
		//  Testing %d: byte, short, int, long
		byte x = 13;
		short y = 14;
		int z = 15;
		long w = 16;
		System.out.printf("%d %d %d %d\n",x,y,z,w);

		// Testing float, double
		// defualt precision of 6 digits to the right of the decimal, so it adds extra zeros if necessary
		System.out.printf("\n%e\n",1276.90); // exponential form
		System.out.printf("%f %f\n",12.90,2.94);
		System.out.printf("%.2f %.2f\n",12.90,2.94); // limits field width, so doesn't add extra zeros

		// Testing char and String 
		char character = 'A';
		String string  = "This is a string";
		Integer integer = 1234;
		System.out.printf("\n%c\n",character);
		System.out.printf("%s %s %s\n",string,integer,character);
		
		// Tests the field width 
		System.out.printf("\n%d%d\n",123,456);
		System.out.printf("%5d%5d\n",123,456); // field width too small, so it right justustifies	
		System.out.printf("%-5d%-5d\n",123,456); // the "-" makes it left justified

		// Tests precision 
		System.out.println();
		System.out.printf("%f\n",1.0789); // defualt 6 digits of precision
		System.out.printf("%.3f\n",1.0789); // rounded to 3 decimal	places
		System.out.printf("%.1f\n",1.0789); // rounded to 1 decimal	place	

		// rounds to 2 decimals, and adds 6 characters of spacing 
		// to the left of each value (field width of 8 characters)
		System.out.printf("%8.2f %88.2f\n",1.0789,2.1234); 
	}
}