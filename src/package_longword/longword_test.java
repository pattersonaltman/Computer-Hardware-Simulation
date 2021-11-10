package package_longword;
import java.util.Random;

import package_bit.*;

public class longword_test {

	public static void main(String[] args) {

		longword_test l = new longword_test();
		l.runTests();
		
		bit_test b = new bit_test();
		b.runTests();
	
		
	}

	public static void runTests() {
		
		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: longword_test.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		runTestsGetBit();
		
		runTestsSetBit();

		runTestsAnd();
		
		runTestsOr();
		
		runTestsXor();
		
		runTestsNot();
		
		runTestRightShift();
		
		runTestLeftShift();
		
		runTestsToString();
		
		runTestsGetUnsigned();
		
		runTestsGetSigned();
		
		runTestsCopy();
		
		runTestsSet();
		
//		runTestsParse();
		
	}
	
	public static void runTestsGetBit() {
		
		System.out.println("Test: getBit()\nSuccess Aim: 32\n");
		
		Random rand = new Random();
		final int max = 2147483647;
		
		int r1 = Math.abs(rand.nextInt(max));
		
		longword l = new longword(r1);
		
		int bitReturns = 0;
		
		for(int i = 0; i < l.lw.length; i++)
		{
			bit test = l.getBit(i);
			if(test instanceof bit)
			{
				bitReturns++;
			}
		}
		System.out.println("# Successful bit returns: "+bitReturns);
		System.out.println("_______________________________________________________________");
	}
	
	public static void runTestsSetBit() {
		
		System.out.println("\nTest: setBit()\n");
		System.out.println("Create & print new longword - All 0 values:\n");
		
		longword l = new longword();
		l.printBinary(0,2);
		
		System.out.println("Set all bits to 1:");
		
		bit b1 = new bit(1);
		
		for(int i = 0; i < l.lw.length; i++)
		{
			l.setBit(i, b1);
		}
		l.printBinary(1,2);
		
		System.out.println("Set all bits back to 0:");
		
		bit b0 = new bit(0);
		
		for(int i = 0; i < l.lw.length; i++)
		{
			l.setBit(i, b0);
		}
		l.printBinary(1,2);
		System.out.println("_______________________________________________________________\n");


	}
	
	public static void runTestsAnd() {
		
		System.out.println("\nTest: and()\n");
		System.out.println("Create 2 random longwords and and() them to check if the result is correct.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1, r2;
		
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,1);
		System.out.print("longword 2: ");
		l2.printBinary(0,2);
		
		//and() the two longwords for the result
		longword result = l1.and(l2);
		
		System.out.print("Result: ");
		result.printBinary(0,1);
		
		System.out.println("_______________________________________________________________\n");
	}
	
	public static void runTestsOr() {
		
		System.out.println("\nTest: or()\n");
		System.out.println("Create 2 random longwords and or() them to check if the result is correct.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1, r2;
		
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,1);
		System.out.print("longword 2: ");
		l2.printBinary(0,2);
		
		//or() the two longwords for the result
		longword result = l1.or(l2);
		
		System.out.print("Result: ");
		result.printBinary(0,1);
		
		System.out.println("_______________________________________________________________\n");

	}
	
	public static void runTestsXor() {
		
		System.out.println("\nTest: xor()\n");
		System.out.println("Create 2 random longwords and xor() them to check if the result is correct.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1, r2;
		
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,1);
		System.out.print("longword 2: ");
		l2.printBinary(0,2);
		
		//xor() the two longwords for the result
		longword result = l1.xor(l2);
		
		System.out.print("Result: ");
		result.printBinary(0,1);
		
		System.out.println("_______________________________________________________________\n");

		
	}
	
	public static void runTestsNot() {
		
		System.out.println("\nTest: not()\n");
		System.out.println("Create a random longword and not() it to invert its bits\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,1);

		//not() the longword to get its negation
		
		longword result = l1.not();
		
		System.out.print("Result: ");
		result.printBinary(0,1);
		
		System.out.println("_______________________________________________________________\n");
	}
	
	public static void runTestRightShift() {
		
		System.out.println("\nTest: rightShift()\n");
		System.out.println("Create a random longword and right-shift it 10 times by 1.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,2);

		//righttShift() the longword 10 times by 1
		
		for(int i = 1; i <= 10; i++)
		{
			longword result = l1.rightShift(i);
			result.printBinary(0,1);
		}
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestLeftShift() {
		
		System.out.println("\nTest: leftShift()\n");
		System.out.println("Create a random longword and left-shift it 10 times by 1.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,2);

		//leftShift() the longword 10 times by 1
		
		for(int i = 1; i <= 10; i++)
		{
			longword result = l1.leftShift(i);
			result.printBinary(0,1);
		}
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestsToString() {
		
		System.out.println("\nTest: toString2()\n");
		System.out.println("Create a random longword and toString2() it to print it out separated by commas.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		
		longword l1 = new longword(r1);
		
		System.out.print("longword 1: ");
		l1.printBinary(0,2);

		//toString() the longword
		
		System.out.println("Result: "+l1.toString2());
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestsGetUnsigned() {
		
		System.out.println("\nTest: getUnsigned()\n");
		System.out.println("Create a random number, print its value, then create a longword with it and"
				+ "print the same value by using getUnsigned().\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		System.out.println("Value of random r1: "+r1);
		
		longword l1 = new longword(r1);
		
		System.out.print("\nlongword 1: ");
		l1.printBinary(0,2);

		//print its value by using getUnsigned()
		
		System.out.println("Value from longword: "+l1.getUnsigned());
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestsGetSigned() {
		
		System.out.println("\nTest: getSigned()\n");
		System.out.println("Create a random number, print its value, then create a longword with it and"
				+ "print the same value by using getSigned().\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		System.out.println("Value of random r1: "+r1);
		
		longword l1 = new longword(r1);
		
		System.out.print("\nlongword 1: ");
		l1.printBinary(0,2);

		//print its value by using getSigned()
		
		System.out.println("Value from longword: "+l1.getSigned());
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestsCopy() {
		
		System.out.println("\nTest: copy()\n");
		System.out.println("Create 1 random longword and 1 longword of all 0 values. Copy the random longword to"
				+ " the 0-value longword and print the new 0-value longword\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		System.out.println("Value of random: "+r1);
		
		longword l1 = new longword(r1);
		
		System.out.print("\nRandom longword: ");
		l1.printBinary(0,2);

		longword zero = new longword();
		System.out.print("Zero longword: ");
		zero.printBinary(0,2);
		
		//copy() the values form the random longword to the zero-longword and print the results
		zero.copy(l1);
		
		System.out.print("Zero longword after copy(): ");
		zero.printBinary(0,1);
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestsSet() {
		
		System.out.println("\nTest: set()\n");
		System.out.println("Create a random number and a 0-value longword. Set the value of"
				+ " the 0-value longword to that of the random number.\n");

		Random rand = new Random();
		final int max = 2147483647;
		int r1;
		
		r1 = Math.abs(rand.nextInt(max));
		System.out.println("Value of random r1: "+r1);
		
		longword l1 = new longword();
		
		System.out.print("\n0-longword: ");
		l1.printBinary(0,2);

		//set() the 0-longword to the value of the random r1
		l1.set(r1);
		
		System.out.print("0-longword after set(): ");
		l1.printBinary(0,1);
		System.out.println("0-longword after set(): "+l1.getSigned());
		
		System.out.println("_______________________________________________________________\n");
		
	}
	
	public static void runTestsParse() {
		
		longword l1 = new longword();
		l1.changeTo("11111111111100000000111111111111");
		
		for(int i = 0; i <= 15; i++)
		{
			int[] intarr = l1.parseAsInt((15-i),(16+i));
		
			for(int j : intarr)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println("\n\n");
		
		
		longword l2 = new longword();
		l2.changeTo("11111111111100000000111111111111");
		
		for(int i = 0; i <= 15; i++)
		{
			bit[] bitarr = l2.parseAsBit((15-i),(16+i));
			
			for(bit j : bitarr)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		System.out.println("\n\n");
		
		
		longword l3 = new longword();
		l3.changeTo("11111111111100000000111111111111");
		
		for(int i = 0; i <= 15; i++)
		{
			String stringarr = l3.parseAsString((15-i),(16+i));
			
			for(int j = 0; j < stringarr.length(); j++)
			{
				System.out.print(stringarr.charAt(j));
			}
			System.out.println();
		}
		
	}
	
}
