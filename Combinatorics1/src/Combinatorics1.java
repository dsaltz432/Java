/*
Daniel Saltz
2/3/15
*/

import java.math.*;

public class Combinatorics1{

	public static void main (String args[]) {
		// part1 question1
		int houses = 3;
		BigInteger colors = new BigInteger("4");
		BigInteger answer = simplePower(colors,houses);
		System.out.println("\nThere are " + answer + " ways to paint the houses");

		// part1 question2
		// 52 letters + 10 numbers = 62 total options
		BigInteger totalOptions = new BigInteger("62"); 
		BigInteger length8 = simplePower(totalOptions,8);
		BigInteger length9 = simplePower(totalOptions,9);
		BigInteger length10 = simplePower(totalOptions,10);
		BigInteger sum = length8.add(length9).add(length10);
		System.out.println("\nThere are " + sum + " different possible passwords");

		// part2
		BigInteger players = new BigInteger("9");
		System.out.println("\nThere are " + fact(players) + " different possible lineups");

		// part3 question1
		BigInteger n = new BigInteger("200");
		BigInteger k = new BigInteger("4");
		System.out.println("\nThere are " + orderedSelect(n,k) + " ways for them to be selected");

		// part3 question2
		BigInteger letters = new BigInteger("26");
		BigInteger m3 = new BigInteger("3");		
		BigInteger m5 = new BigInteger("5");
		System.out.println("\nFor m = 3, there are " 
			+ orderedSelect(letters,m3) + " possible sequences");
		System.out.println("\nFor m = 5, there are " 
			+ orderedSelect(letters,m5) + " possible sequences");

		// part4
		BigInteger deck = new BigInteger("52");
		BigInteger hand = new BigInteger("5");
		System.out.println("\nThere are " + unordSelect(deck,hand)
							 + " possible hands in a poker deck");
	}

	private static BigInteger orderedSelect(BigInteger n, BigInteger k) {

		BigInteger nFact = fact(n);
		BigInteger nMinusKFact = fact(n.subtract(k));
		BigInteger quotient = nFact.divide(nMinusKFact);
		return quotient;
	}

	public static BigInteger simplePower(BigInteger k, int n){
		return k.pow(n);
	}

	public static BigInteger unordSelect(BigInteger n, BigInteger k){
		BigInteger nFact = fact(n);
		BigInteger nMinusKFact = fact(n.subtract(k));
		BigInteger mFact = fact(k);
		BigInteger answer = nFact.divide(nMinusKFact.multiply(mFact));
		return answer;
	}

	public static BigInteger fact(BigInteger n){
		BigInteger iterator = new BigInteger("1");
		BigInteger fact = new BigInteger("1");
	    while (iterator.compareTo(n) <= 0){
	        fact = fact.multiply(iterator);
	        iterator = iterator.add(BigInteger.ONE);
	    }
	    return fact;
	}
}