package package_Multiplier_ALU;
import java.util.Random;

import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class multiplier_test {

	public static void main(String[] args) {

		multiplier_test m = new multiplier_test();
		m.runTests();
		
		rippleAdder_test r = new rippleAdder_test();
		r.runTests();
		
		longword_test l = new longword_test();
		l.runTests();
		
		bit_test b = new bit_test();
		b.runTests();
		
	}

public static void runTests() {
	
	System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
	System.out.println("Tests for the class: multiplier_test.java");
	System.out.println("__________________________________________________________________________________\n\n\n\n\n");
	
	
	
	/*
	 * Testing outline:
	 * 	- create 5 Aim-test cases from 10 large random numbers (decimal) - 2 numbers per test case (a & b)
	 *	- do a * b with regular multiplication for the 10 numbers - to get the 5 Aim-test case results (decimal)
	 *	- display the decimal and binary forms of the 5 Aim-test cases
	 *	- Now recreate the Aim-test cases using the Multiplier multiply() method
	 *	- display the decimal and binary forms of the results from the Multipler
	 *	- Compare the decimal & binary values - they should be equivalent
	 */
	
	
	// make random numbers (1-10)
	int r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
	Random rand = new Random();
	final int max = 46340;		// sqrt(2147483647) : Therefore largest number where max^2 won't exceed 2147483647

	r1 = Math.abs(rand.nextInt(max));
	r2 = Math.abs(rand.nextInt(max));
	r3 = Math.abs(rand.nextInt(max));
	r4 = Math.abs(rand.nextInt(max));
	r5 = Math.abs(rand.nextInt(max));
	r6 = Math.abs(rand.nextInt(max));
	r7 = Math.abs(rand.nextInt(max));
	r8 = Math.abs(rand.nextInt(max));
	r9 = Math.abs(rand.nextInt(max));
	r10 = Math.abs(rand.nextInt(max));

	
	// make Aim-test cases with regular multiplication (5) (Decimal)
	int aim1, aim2, aim3, aim4, aim5;
	
	aim1 = r1 * r2;
	aim2 = r3 * r4;
	aim3 = r5 * r6;
	aim4 = r7 * r8;
	aim5 = r9 * r10;
	
	// make longword versions of Aim-test cases (5) (Binary)
	longword lwAim1 = new longword(aim1);
	longword lwAim2 = new longword(aim2);
	longword lwAim3 = new longword(aim3);
	longword lwAim4 = new longword(aim4);
	longword lwAim5 = new longword(aim5);
	
	
	
	// display the random numbers (r1-r10) (Decimal)
	System.out.println("Random numbers (r1-r10):\n");
	System.out.print("r1: "+r1+"\tr2: "+r2+"\tr3: "+r3+"\tr4: "+r4+"\tr5: "+r5+"\nr6: "+r6+"\tr7: "
			+r7+"\tr8: "+r8+"\tr9: "+r9+"\tr10: "+r10+"\n");
	System.out.print("____________________________________________________________________________\n\n");
	
	
	
	
	// display the decimal and binary forms for Aim-test cases (Decimal and Binary)
	/* Note: the printBinary(int, int) method just prints the longword's bit array.
	 * 		The int arguments are just the # of newlines to be entered before and after the longword */
	System.out.println("Aim-test cases (aim1-aim5) (Decimal & Binary):");
	System.out.println("-These test cases are calculated by regular multiplication.\n");
	System.out.print("aim1:\nDecimal: "+aim1+" | Binary: ");
	lwAim1.printBinary(0,2);
	System.out.print("aim2:\nDecimal: "+aim2+" | Binary: ");
	lwAim2.printBinary(0,2);
	System.out.print("aim3:\nDecimal: "+aim3+" | Binary: ");
	lwAim3.printBinary(0,2);
	System.out.print("aim4:\nDecimal: "+aim4+" | Binary: ");
	lwAim4.printBinary(0,2);
	System.out.print("aim5:\nDecimal: "+aim5+" | Binary: ");
	lwAim5.printBinary(0,1);
	
	System.out.print("____________________________________________________________________________\n\n");
	
	// Recreate the aim-test cases by using the Multipler (lwResult1 - lwResult5):
	
	// First make longwords for the same random values used in the aim-test cases (lwrand1 - lwrand5)
	longword lwrand1 = new longword(r1);
	longword lwrand2 = new longword(r2);
	longword lwrand3 = new longword(r3);
	longword lwrand4 = new longword(r4);
	longword lwrand5 = new longword(r5);
	longword lwrand6 = new longword(r6);
	longword lwrand7 = new longword(r7);
	longword lwrand8 = new longword(r8);
	longword lwrand9 = new longword(r9);
	longword lwrand10 = new longword(r10);
	
	// Now multiply to get the result-test cases (lwResult1 - lwResult5)
	Multiplier m = new Multiplier();
	
	longword lwResult1 = m.multiply(lwrand1, lwrand2);
	longword lwResult2 = m.multiply(lwrand3, lwrand4);
	longword lwResult3 = m.multiply(lwrand5, lwrand6);
	longword lwResult4 = m.multiply(lwrand7, lwrand8);
	longword lwResult5 = m.multiply(lwrand9, lwrand10);
	
	
	// display the decimal & binary forms of the result-test cases from the Multiplier (lwResult1 - lwResult5)
	System.out.println("Result-test cases (lwResult1 - lwResult5) (Decimal & Binary):");
	System.out.println("-These result cases are calculated using the Multipler.multiply() method.\n");
	System.out.print("lwResult1:\nDecimal: "+lwResult1.getUnsigned()+" | Binary: ");
	lwResult1.printBinary(0,2);
	System.out.print("lwResult2:\nDecimal: "+lwResult2.getUnsigned()+" | Binary: ");
	lwResult2.printBinary(0,2);
	System.out.print("lwResult3:\nDecimal: "+lwResult3.getUnsigned()+" | Binary: ");
	lwResult3.printBinary(0,2);
	System.out.print("lwResult4:\nDecimal: "+lwResult4.getUnsigned()+" | Binary: ");
	lwResult4.printBinary(0,2);
	System.out.print("lwResult5:\nDecimal: "+lwResult5.getUnsigned()+" | Binary: ");
	lwResult5.printBinary(0,2);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
}
