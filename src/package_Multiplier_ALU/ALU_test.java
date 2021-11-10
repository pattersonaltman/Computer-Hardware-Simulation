package package_Multiplier_ALU;
import java.util.Random;

import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class ALU_test {

	public static void main(String[] args) {

		ALU_test a = new ALU_test();
		a.runTests();
		
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
		System.out.println("Tests for the class: ALU_test.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		runTestsAnd();
		
		runTestsOr();
		
		runTestsXor();
		
		runTestsNot2();
		
		runTestsLeftShift2();
		
		runTestsRightShift2();
		
		runTestsAdd();
		
		runTestsSubtract();
		
		runTestsMultiply();
		
	}
	
	public static void runTestsAnd() {
		
		System.out.println("Test for: and()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 2147483647;
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,1);
		System.out.print("r2 = Decimal: "+r2+" | Binary: ");
		l2.printBinary(0,2);
		
		
		//and() the 2 longwords via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1000");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
	}
	
	public static void runTestsOr() {
		
		System.out.println("Test for: or()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 2147483647;
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,1);
		System.out.print("r2 = Decimal: "+r2+" | Binary: ");
		l2.printBinary(0,2);
		
		
		//or() the 2 longwords via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1001");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
	}
	
	public static void runTestsXor() {
		
		System.out.println("Test for: xor()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 2147483647;
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,1);
		System.out.print("r2 = Decimal: "+r2+" | Binary: ");
		l2.printBinary(0,2);
		
		
		//xor() the 2 longwords via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1010");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
		
	}
	
//	public static void runTestsNot() {
//		
//		System.out.println("Test for: not()\n");
//		
//		//create random numbers
//		Random rand = new Random();
//		int r1;
//		final int max = 2147483647;
//		r1 = Math.abs(rand.nextInt(max));
//		
//		//create longwords from the randoms
//		longword l1 = new longword(r1);
//		
//		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
//		l1.printBinary(0,2);
//
//		
//		
//		//not() the longword via ALU.doOp()
//		//First create the operation bit-code
//		bit b = new bit();
//		bit[] op = b.strToBitArr("1011");
//		
//		ALU alu = new ALU();
//		longword result = alu.doOp(op, l1);
//		
//		//Print result (Decimal & Binary)
//		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
//		result.printBinary(0,1);
//		
//		System.out.println("______________________________________________________________________________\n\n");
//		
//		
//	}
	
//	public static void runTestsLeftShift(int amount) {
//		
//		System.out.println("Test for: leftShift()\n");
//		
//		//create random numbers
//		Random rand = new Random();
//		int r1;
//		final int max = 2147483647;
//		r1 = Math.abs(rand.nextInt(max));
//		
//		//create longwords from the randoms
//		longword l1 = new longword(r1);
//		
//		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
//		l1.printBinary(0,2);
//
//		
//		
//		//leftShift() the longword via ALU.doOp()
//		//First create the operation bit-code
//		bit b = new bit();
//		bit[] op = b.strToBitArr("1100");
//		
//		ALU alu = new ALU();
//		longword result = alu.doOp(op, l1, amount);
//		
//		//Print result (Decimal & Binary)
//		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
//		result.printBinary(0,1);
//		
//		System.out.println("______________________________________________________________________________\n\n");
//		
//		
//	}
	
//	public static void runTestsRightShift(int amount) {
//		
//		System.out.println("Test for: rightShift()\n");
//		
//		//create random numbers
//		Random rand = new Random();
//		int r1;
//		final int max = 2147483647;
//		r1 = Math.abs(rand.nextInt(max));
//		
//		//create longwords from the randoms
//		longword l1 = new longword(r1);
//		
//		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
//		l1.printBinary(0,2);
//
//		
//		
//		//rightShift() the longword via ALU.doOp()
//		//First create the operation bit-code
//		bit b = new bit();
//		bit[] op = b.strToBitArr("1101");
//		
//		ALU alu = new ALU();
//		longword result = alu.doOp(op, l1, amount);
//		
//		//Print result (Decimal & Binary)
//		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
//		result.printBinary(0,1);
//		
//		System.out.println("______________________________________________________________________________\n\n");
//		
//		
//	}
	
	public static void runTestsAdd() {

		System.out.println("Test for: add()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 1073741823;			//Half of 2147483647
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,1);
		System.out.print("r2 = Decimal: "+r2+" | Binary: ");
		l2.printBinary(0,2);
		
		
		//add() the 2 longwords via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1110");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
	}
	
	public static void runTestsSubtract() {

		System.out.println("Test for: subtract()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 2147483647;			
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,1);
		System.out.print("r2 = Decimal: "+r2+" | Binary: ");
		l2.printBinary(0,2);
		
		
		//subtract() the 2 longwords via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1111");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
		
		
	}
	
	public static void runTestsMultiply() {

		System.out.println("Test for: multiply()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 46340;		// sqrt(2147483647) : Therefore largest number where max^2 won't exceed 2147483647	
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,1);
		System.out.print("r2 = Decimal: "+r2+" | Binary: ");
		l2.printBinary(0,2);
		
		
		//multiply() the 2 longwords via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("0111");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
		
		
	}
	
	public static void runTestsLeftShift2() {
		
		System.out.println("Test for: leftShift()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 2147483647;
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(32));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,2);
		
		System.out.print("Amount to left shift by: "+l2.getSigned()+" | Binary: ");
		l2.printBinary(0,2);
	
		
		//leftShift() the longword via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1100");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
		
	}
	
	public static void runTestsRightShift2() {
		
		System.out.println("Test for: rightShift()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1, r2;
		final int max = 2147483647;
		r1 = Math.abs(rand.nextInt(max));
		r2 = Math.abs(rand.nextInt(32));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,2);
		
		System.out.print("Amount to right shift by: "+l2.getSigned()+" | Binary: ");
		l2.printBinary(0,2);
	
		
		//leftShift() the longword via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1101");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
		
	}
	
	public static void runTestsNot2() {
		
		System.out.println("Test for: not()\n");
		
		//create random numbers
		Random rand = new Random();
		int r1;
		final int max = 2147483647;
		r1 = Math.abs(rand.nextInt(max));
		
		//create longwords from the randoms
		longword l1 = new longword(r1);
		longword l2 = new longword();	//2nd longword argument (longword b) - has no value because it will be ignored
		
		System.out.print("r1 = Decimal: "+r1+" | Binary: ");
		l1.printBinary(0,2);

		
		
		//not() the longword via ALU.doOp()
		//First create the operation bit-code
		bit b = new bit();
		bit[] op = b.strToBitArr("1011");
		
		ALU alu = new ALU();
		longword result = alu.doOp(op, l1, l2);
		
		//Print result (Decimal & Binary)
		System.out.print("result = Decimal: "+result.getUnsigned()+" | Binary: ");
		result.printBinary(0,1);
		
		System.out.println("______________________________________________________________________________\n\n");
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}		//end class
