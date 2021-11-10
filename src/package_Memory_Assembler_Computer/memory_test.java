package package_Memory_Assembler_Computer;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

import java.util.Random;

import package_Multiplier_ALU.*;

public class memory_test {

	public static void main(String[] args) {

		memory_test mem = new memory_test();
		mem.runTests();
		
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
		System.out.println("Tests for the class: memory.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		System.out.println("This test:\n- Creates a new memory.\n- Creates a random integer value and address."
				+ "\n- Creates a longword value and address from the integer values.\n- Writes the longword value"
				+ " to the address in memory with the function: write(longword address, longword value)."
				+ "\n- Reads the value written to the address with the function: read(longword address)."
				+ "\n- Prints the entire memory array after both tests have been conducted."
				+ "\n\t- Note: If the positive and negative tests write to the same address by random, the first"
				+ "\n\t\tvalue will be overwritten.\n\n\n");
		
		Memory m = new Memory(8192);	//create new memory - 1024 bytes
		
		Random rand = new Random();	
		
		final int sizeVal = 2147483647;
		final int sizeAdr = m.getMaxAddress();
		int rVal, rAddress;
		rVal = rand.nextInt(sizeVal);			//create random value for longword, within possible bounds
		rAddress = rand.nextInt(sizeAdr);		//create random address for longword in bit array, within possible bounds
		
		longword lVal = new longword(rVal);				//create longword value
		longword lAddr = new longword(rAddress);		//create longword address
		
		/* Value to be stored */
		
		System.out.println("Positive Test:\n");
		System.out.println("Value to be stored (Decimal): "+rVal);
		System.out.print("Value to be stored (Binary): ");
		lVal.printBinary(0,1);
		System.out.println("Address to be stored at: "+rAddress+"\n");
		
		/* write() longword value to address */
		
		m.write(lAddr,  lVal);
		System.out.print("Value stored at address ["+rAddress+"]: ");
		lVal.printBinary(0,2);
		
		/* read() longword value from the address just used to store at */
		
		longword readValue = m.read(lAddr);
		
		System.out.print("Value read from address ["+rAddress+"]: ");
		readValue.printBinary(0,2);
		
		
		/* Test again for negative numbers */
		
		final int sizeVal2 = 2147483647;
		final int sizeAdr2 = m.getMaxAddress();
		int rVal2, rAddress2;
		rVal2 = rand.nextInt(sizeVal2);			//create random value for longword, within possible bounds
		rVal2 = (~(rVal2 - 1));					//convert random positive value rVal2 into a negative value
		rAddress2 = rand.nextInt(sizeAdr2);		//create random address for longword in bit array, within possible bounds
		
		longword lVal2 = new longword(rVal2);				//create longword value
		longword lAddr2 = new longword(rAddress2);		//create longword address
		
		/* Value to be stored */
		
		System.out.println("\n\nNegative Test:\n");
		System.out.println("Value to be stored (Decimal): "+rVal2);
		System.out.print("Value to be stored (Binary): ");
		lVal2.printBinary(0,1);
		System.out.println("Address to be stored at: "+rAddress2+"\n");
		
		/* write() longword value to address */
		
		m.write(lAddr2,  lVal2);
		System.out.print("Value stored at address ["+rAddress2+"]: ");
		lVal2.printBinary(0,2);
		
		/* read() longword value from the address just used to store at */
		
		longword readValue2 = m.read(lAddr2);
		
		System.out.print("Value read from address ["+rAddress2+"]: ");
		readValue2.printBinary(0,2);
		
		
		/* Print entire memory */
		System.out.println("\n_______________________________\n");
		System.out.println("Print the entire memory array...\n\nNote: Addresses to write to are generated randomly - if "
				+ "the positive and negative tests happen \nrandomly to get chosen the same address, "
				+ "only the second value (negative) will appear in memory.\n");
		System.out.println("- To find the values written into memory:\n\t\tGo to row: Row = Address / # Columns\n");
		System.out.println("\nFull memory print:\n");
		m.printMem();
	}
	
	
}
































