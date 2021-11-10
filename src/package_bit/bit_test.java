package package_bit;

public class bit_test {

	public static void main(String[] args) {

		bit_test b = new bit_test();
		b.runTests();
		
	}
	
	public static void runTests() {
		
		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: bit_test.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		/* Test method: set(int value) */
		
		bit testSetVal1 = new bit(0);
		bit testSetVal2 = new bit(1);

		System.out.println("Method: set(int value) (1) | Expected value: 0 | testSetVal1 value: " + testSetVal1);
		System.out.println("Method: set(int value) (2) | Expected value: 1 | testSetVal1 value: " + testSetVal2);
		System.out.println("\n");
		
		/* Test method: toggle() */
		
		bit testToggle1 = new bit(0);
		System.out.print("Method: toggle() (1) | Expected value: 1 | Initial value: " + testToggle1 + " | ");		
		testToggle1.toggle();
		System.out.println("Value after toggle(): " + testToggle1);
		
		bit testToggle2 = new bit(1);
		System.out.print("Method: toggle() (2) | Expected value: 0 | Initial value: " + testToggle2 + " | ");		
		testToggle2.toggle();
		System.out.println("Value after toggle(): " + testToggle2);
		System.out.println("\n");

		/* Test method: set() */
		
		bit testSet1 = new bit(0);
		System.out.print("Method: set() (1) | Expected value: 1 | Initial value: " + testSet1 + " | ");
		testSet1.set();
		System.out.println("Value after set(): " + testSet1);
		
		bit testSet2 = new bit(1);
		System.out.print("Method: set() (2) | Expected value: 1 | Initial value: " + testSet2 + " | ");
		testSet2.set();
		System.out.println("Value after set(): " + testSet2);
		
		System.out.println("\n");
		
		/* Test method: clear() */
		
		bit testClear1 = new bit(1);
		System.out.print("Method: clear() (1) | Expected value: 0 | Initial value: " + testClear1 + " | ");
		testClear1.clear();
		System.out.println("Value after clear(): " + testClear1);
		
		bit testClear2 = new bit(0);
		System.out.print("Method: clear() (2) | Expected value: 0 | Initial value: " + testClear2 + " | ");
		testClear2.clear();
		System.out.println("Value after clear(): " + testClear2);
		
		System.out.println("\n");
		
		/* Test method: getValue() */
		
		bit testGetValue1 = new bit(0);
		System.out.println("Method: getValue() (1) | Initialization value: 0 | Returned value: " + testGetValue1.getValue());
		bit testGetValue2 = new bit(1);
		System.out.println("Method: getValue() (2) | Initialization value: 1 | Returned value: " + testGetValue2.getValue());
		
		System.out.println("\n");
		
		/* Test method: and() */
		
		
		bit testAnd1 = new bit(0);
		bit testAnd2 = new bit(0);
		bit otherAndBit1 = new bit(0);
		bit otherAndBit2 = new bit(1);
		
		bit andResult1 = testAnd1.and(otherAndBit1);
		System.out.println("Method: and() (1) | Expected value: 0 | andResult value: " + andResult1);
		bit andResult2 = testAnd2.and(otherAndBit2);
		System.out.println("Method: and() (2) | Expected value: 0 | andResult value: " + andResult2);
		
		bit testAnd3 = new bit(1);
		bit testAnd4 = new bit(1);
		bit otherAndBit3 = new bit(0);
		bit otherAndBit4 = new bit(1);
		
		bit andResult3 = testAnd3.and(otherAndBit3);
		System.out.println("Method: and() (3) | Expected value: 0 | andResult value: " + andResult3);
		bit andResult4 = testAnd4.and(otherAndBit4);
		System.out.println("Method: and() (4) | Expected value: 1 | andResult value: " + andResult4);
		
		System.out.println("\n");

		/* Test method: or() */
		
		bit testOr1 = new bit(0);
		bit testOr2 = new bit(0);
		bit otherOrBit1 = new bit(0);
		bit otherOrBit2 = new bit(1);
		
		bit orResult1 = testOr1.or(otherOrBit1);
		System.out.println("Method: or() (1) | Expected value: 0 | orResult value: " + orResult1);
		bit orResult2 = testOr2.or(otherOrBit2);
		System.out.println("Method: or() (2) | Expected value: 1 | orResult value: " + orResult2);
		
		bit testOr3 = new bit(1);
		bit testOr4 = new bit(1);
		bit otherOrBit3 = new bit(0);
		bit otherOrBit4 = new bit(1);
		
		bit orResult3 = testOr3.or(otherOrBit3);
		System.out.println("Method: or() (3) | Expected value: 1 | orResult value: " + orResult3);
		bit orResult4 = testOr4.or(otherOrBit4);
		System.out.println("Method: or() (4) | Expected value: 1 | orResult value: " + orResult4);
		
		System.out.println("\n");

		/* Test method: xor() */
		
		bit testXor1 = new bit(0);
		bit testXor2 = new bit(0);
		bit otherXor1 = new bit(0);
		bit otherXor2 = new bit(1);
		
		bit xorResult1 = testXor1.xor(otherXor1);
		System.out.println("Method: xor() (1) | Expected value: 0 | xorResult value: " + xorResult1);
		bit xorResult2 = testXor2.xor(otherXor2);
		System.out.println("Method: xor() (2) | Expected value: 1 | xorResult value: " + xorResult2);
		
		bit testXor3 = new bit(1);
		bit testXor4 = new bit(1);
		bit otherXor3 = new bit(0);
		bit otherXor4 = new bit(1);
		
		bit xorResult3 = testXor3.xor(otherXor3);
		System.out.println("Method: xor() (3) | Expected value: 1 | xorResult value: " + xorResult3);
		bit xorResult4 = testXor4.xor(otherXor4);
		System.out.println("Method: xor() (4) | Expected value: 0 | xorResult value: " + xorResult4);
		
		System.out.println("\n");

		/* Test method: not() */
		
		bit testNot1 = new bit(0);
		bit testNot2 = new bit(1);
		
		bit notResult1 = testNot1.not();
		bit notResult2 = testNot2.not();
		
		System.out.println("Method: not() (1) | Expected value: 1 | First bit value: " + testNot1 + " | New bit value: " + notResult1);
		System.out.println("Method: not() (2) | Expected value: 0 | First bit value: " + testNot2 + " | New bit value: " + notResult2);
		
		System.out.println("\n");

		/* Test toString() */
		
		bit testToString1 = new bit(0);
		bit testToString2 = new bit(1);
		
		String str1 = testToString1.toString();
		String str2 = testToString2.toString();
		
		System.out.println("Method: toString() (1) | Expected value: 0 | Bit value: " + testToString1 + " | String: " + str1);
		System.out.println("Method: toString() (2) | Expected value: 1 | Bit value: " + testToString2 + " | String: " + str2);
		
		System.out.println("\n");

	}

}
