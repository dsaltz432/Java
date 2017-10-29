/*
Daniel Saltz
2/3/15
*/

import java.math.*;

public class Combinatorics2{
	
	public static void main (String args[])
	{
		/* ***********   Answering part1 **************************/
		int [] array = {1,1,1};

		// error
		BigInteger letters1 = new BigInteger("5");
		array[0] = 3;
		BigInteger answer1 = orderingWithIdenticalItems(letters1,array);
		System.out.println("\nThere are " + answer1 + " anagrams in \"error\"");

		// street
		BigInteger letters2 = new BigInteger("6");
		array[0] = 2;
		array[1] = 2;
		BigInteger answer2 = orderingWithIdenticalItems(letters2,array);
		System.out.println("\nThere are " + answer2 + " anagrams in \"street\"");

		// allele
		BigInteger letters3 = new BigInteger("6");
		array[0] = 3;
		array[1] = 2;
		BigInteger answer3 = orderingWithIdenticalItems(letters3,array);
		System.out.println("\nThere are " + answer3 + " anagrams in \"allele\"");

		// mississippi
		BigInteger letters4 = new BigInteger("11");
		array[0] = 4;
		array[1] = 4;
		array[2] = 2;
		BigInteger answer4 = orderingWithIdenticalItems(letters4,array);
		System.out.println("\nThere are " + answer4 + " anagrams in \"mississippi\"");


		/* ***********   Answering part2 ******************************/
		// 6 apples to 4 children
		BigInteger n1 = new BigInteger("6");
		BigInteger m1 = new BigInteger("4");
		BigInteger a1 = similarBins(n1,m1);
		System.out.println("\nThere are " + a1 + " ways to distribute the apples among 4 children");

		// 4 apples to 6 children
		BigInteger n2 = new BigInteger("4");
		BigInteger m2 = new BigInteger("6");
		BigInteger a2 = similarBins(n2,m2);
		System.out.println("\nThere are " + a2 + " ways to distribute the apples among 6 children");

		/* ***********   Answering part3 ******************************/
		// 6 apples and 3 pears to 5 children
		BigInteger d1 = new BigInteger("6");
		BigInteger d2 = new BigInteger("3");
		BigInteger d3 = BigInteger.ONE;
		BigInteger obj1 = new BigInteger("5");
		BigInteger ans1 = differentBins(d1,d2,d3,obj1);
		System.out.println("\nThere are " + ans1 + " ways to distribute the fruit");

		// 2 apples, 5 pears, 6 bananas to 3 children
		BigInteger e1 = new BigInteger("2");
		BigInteger e2 = new BigInteger("5");
		BigInteger e3 = new BigInteger("6");
		BigInteger obj2 = new BigInteger("3");
		BigInteger ans2 = differentBins(e1,e2,e3,obj2);
		System.out.println("\nThere are " + ans2 + " ways to distribute the fruit");
	}

	// part1
	public static BigInteger orderingWithIdenticalItems(BigInteger totalLetters, int [] repeats){
		BigInteger totalCombinations = fact(totalLetters);
		BigInteger r1 = BigInteger.valueOf(repeats[0]);
		BigInteger r2 = BigInteger.valueOf(repeats[1]);
		BigInteger r3 = BigInteger.valueOf(repeats[2]);
		BigInteger repeated = fact(r3).multiply(fact(r1).multiply(fact(r2)));
		BigInteger answer = totalCombinations.divide(repeated);
		return answer;
	}

	// part2
	public static BigInteger similarBins(BigInteger n, BigInteger m){	
		BigInteger nPlusmMinus1 = n.add(m).subtract(BigInteger.ONE);
		BigInteger nPlusmMinus1Fact = fact(nPlusmMinus1);
		BigInteger denom = fact(nPlusmMinus1.subtract(n)).multiply(fact(n));
		BigInteger answer = nPlusmMinus1Fact.divide(denom);
		return answer;
	}

	// part 3
	public static BigInteger differentBins(BigInteger n1, BigInteger n2, BigInteger n3, BigInteger obj){	
		BigInteger appleComb = similarBins(n1,obj);
		BigInteger pearComb = similarBins(n2,obj);
		BigInteger bananaComb;

		if (n3.equals(BigInteger.ONE) == false)
			bananaComb = similarBins(n3,obj);
		else
			bananaComb = BigInteger.ZERO;
		
		BigInteger answer = bananaComb.add(appleComb.add(pearComb));
		return answer;
	}

	// calculates the factorial given BigInteger n
	public static BigInteger fact(BigInteger n)
	{
		BigInteger iterator = BigInteger.ONE;
		BigInteger fact = BigInteger.ONE;

	    while (iterator.compareTo(n) <= 0)
	    {
	        fact = fact.multiply(iterator);
	        iterator = iterator.add(BigInteger.ONE);
	    }
	    return fact;
	}
}