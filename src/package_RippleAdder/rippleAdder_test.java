package package_RippleAdder;
import package_bit.*;
import package_longword.*;

import java.util.Random;


public class rippleAdder_test {

	public rippleAdder_test() {}
	
	public static void main(String[] args) {

		rippleAdder_test r = new rippleAdder_test();
		r.runTests();
		
		longword_test l = new longword_test();
		l.runTests();
		
		bit_test b = new bit_test();
		b.runTests();
		
	}

	public static void runTests() {
		
		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: rippleAdder_test.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		/*
		 * How test will execute:
		 *		- 4 tests total
		 *		- make 5 random #'s (r1 - r5)
		 *		- do (r2 through r5) + r1  --> 4 random sums
		 *		- show what the 4 random sums are in binary & decimal form
		 *		- replicate the binary & decimal forms by adding the respective binary forms (longwords)
		 *		  together (binary forms of: r1 + (r2 through r5) with the add() method
		 *		- display the replicated value as binary and decimal form to check if they are the same 
		 */
		
		int r1, r2, r3, r4, r5, temp2, temp3, temp4, temp5;
		final int max = 1073741823;				//half of 2147483647, rounded down - ensures no negative test values will be used by creating a sum > max int size.
		final int size = 32;
		
		Random rand = new Random();
		Math.abs(r1 = rand.nextInt(max));
		Math.abs(temp2 = rand.nextInt(max));
		Math.abs(temp3 = rand.nextInt(max));
		Math.abs(temp4 = rand.nextInt(max));
		Math.abs(temp5 = rand.nextInt(max));
		
		r2 = r1 + temp2;
		r3 = r1 + temp3;
		r4 = r1 + temp4;
		r5 = r1 + temp5;
		longword l1 = new longword(r1);
		longword l2 = new longword(r2);
		longword l3 = new longword(r3);
		longword l4 = new longword(r4);
		longword l5 = new longword(r5);
		
		longword lwtemp2 = new longword(temp2);
		longword lwtemp3 = new longword(temp3);
		longword lwtemp4 = new longword(temp4);
		longword lwtemp5 = new longword(temp5);
		

		System.out.println("Random numbers (r1, temp2 - temp5): ");
		System.out.print("\nr1: Decimal: "+r1+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(l1.lw[i].getValue());
		}
		System.out.print("\ntemp2: Decimal: "+temp2+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(lwtemp2.lw[i].getValue());
		}
		System.out.print("\ntemp3: Decimal: "+temp3+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(lwtemp3.lw[i].getValue());
		}
		System.out.print("\ntemp4: Decimal: "+temp4+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(lwtemp4.lw[i].getValue());
		}
		System.out.print("\ntemp5: Decimal: "+temp5+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(lwtemp5.lw[i].getValue());
		}
		
	
		
		
		System.out.println("\n\n\nAddition Aim-test cases (r2-r5):");
		System.out.print("\nr2: Decimal: "+r2+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(l2.lw[i].getValue());
		}
		System.out.print("\nr3: Decimal: "+r3+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(l3.lw[i].getValue());
		}
		System.out.print("\nr4: Decimal: "+r4+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(l4.lw[i].getValue());
		}
		System.out.print("\nr5: Decimal: "+r5+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(l5.lw[i].getValue());
		}
		
		
		/*
		 * - testing add() method here
		 * - make RippleAdder object
		 * - add r1 (binary) with (temp2-temp5 (binary))
		 */
		
		RippleAdder rp = new RippleAdder();
		longword addAns2 = rp.add(l1, lwtemp2);
		longword addAns3 = rp.add(l1, lwtemp3);
		longword addAns4 = rp.add(l1, lwtemp4);
		longword addAns5 = rp.add(l1, lwtemp5);
		
		System.out.println("\n\n\nAddition test results:");
		System.out.println("- Aim-results: created using regular addition and creating new longwords\n"
				+ "- Test results: created using ripple-adder function add(lonword a, longword b)");
		System.out.println("- Check Answer Binary/Decimal forms - they should match the Addition Aim-test cases.");
		
		System.out.print("\nAnswer 2 Decimal: "+addAns2.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(addAns2.lw[i].getValue());
		}
		System.out.print("\nAnswer 3 Decimal: "+addAns3.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(addAns3.lw[i].getValue());
		}
		System.out.print("\nAnswer 4 Decimal: "+addAns4.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(addAns4.lw[i].getValue());
		}
		System.out.print("\nAnswer 5 Decimal: "+addAns5.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(addAns5.lw[i].getValue());
		}
		
		
		/*
		 * Subtraction Test:
		 * - take answers from ans2, ans3, ans4, ans5
		 * - subtract r1 from each using subtract()
		 * - Result should = temp2, temp3, temp4, temp5 respectively
		 * - Check binary and decimal forms to confirm results
		 */
		
		System.out.println("\n\n\nSubtraction test results:\n"
				+ "- Test results: created using ripple-adder function subtract(longword a, longword b)");
		System.out.println("- Check Answer Binary/Decimal forms - they should match the original values of: temp2, temp3, temp4, temp5 respectively.\n");
		
		longword difAns2 = rp.subtract(addAns2, l1);
		longword difAns3 = rp.subtract(addAns3, l1);
		longword difAns4 = rp.subtract(addAns4, l1);
		longword difAns5 = rp.subtract(addAns5, l1);
		
		System.out.print("Answer 2 Decimal: "+difAns2.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(difAns2.lw[i].getValue());
		}
		System.out.println();
		System.out.print("Answer 3 Decimal: "+difAns3.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(difAns3.lw[i].getValue());
		}
		System.out.println();
		System.out.print("Answer 4 Decimal: "+difAns4.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(difAns4.lw[i].getValue());
		}
		System.out.println();
		System.out.print("Answer 5 Decimal: "+difAns5.getUnsigned()+" | Binary: ");
		for(int i = 0; i < size; i++)
		{
			System.out.print(difAns5.lw[i].getValue());
		}
		System.out.println();
		
		
		
	}
	
}
