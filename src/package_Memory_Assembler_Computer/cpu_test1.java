package package_Memory_Assembler_Computer;
import package_Multiplier_ALU.*;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class cpu_test1 {

	public static void main(String[] args) {

		cpu_test1 cpu1 = new cpu_test1();
		cpu1.runTests();
		
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
		System.out.println("Tests for the class: cpu_test1.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		runTestHalt();
		
		runTestMove();
		
		runTestInterrupt_0();
		
		runTestInterrupt_1();
		
//		runTestNot();
		
		
	}
	
	public static void runTestHalt() {
		
		System.out.println("Test for: Halt\n");
		
		
		Computer cpu = new Computer();
		
		String[] instructions = new String[1];
		instructions[0] = "0000000000000000";

		cpu.halted.set(0);
		if(cpu.halted.getValue() == 0)
		{
			System.out.println("halted value is: "+cpu.halted.getValue()+" | CPU is running");
		}
		
		cpu.preload(instructions);
		cpu.run();
		
		if(cpu.halted.getValue() == 1)
		{
			System.out.println("halted value is: "+cpu.halted.getValue()+" | CPU is halted");
		}
		
		System.out.println("______________________________________________________________________________\n\n");
		
	}
	
	public static void runTestMove() {
		
		System.out.println("Test for: Move\n");
		
		System.out.println("Test 1: Even length instruction String[] array\n");
		
		Computer cpu1 = new Computer();
		cpu1.halted.set(0);
		String[] instructions1 = new String[8];
		instructions1[0] = "0001000000000001";
		instructions1[1] = "0001000100000011";
		instructions1[2] = "0001001000000111";
		instructions1[3] = "0001001100001111";
		instructions1[4] = "0001010000011111";
		instructions1[5] = "0001010100111111";
		instructions1[6] = "0001011001111111";
		instructions1[7] = "0001011111111111";
 
		for(int i = 0; i < 8; i++)
		{
			cpu1.registers[i].printBinary(0,1);
		}
		System.out.println();
		
		cpu1.preload(instructions1);
		cpu1.run();
		
		
		for(int i = 0; i < 8; i++)
		{
			cpu1.registers[i].printBinary(0,1);
		}
		
		
		System.out.println("\nTest 2: Odd length instruction String[] array\n");
		
		Computer cpu2 = new Computer();
		cpu2.halted.set(0);
		String[] instructions2 = new String[7];
		instructions2[0] = "0001000000000001";
		instructions2[1] = "0001000100000011";
		instructions2[2] = "0001001000000111";
		instructions2[3] = "0001001100001111";
		instructions2[4] = "0001010000011111";
		instructions2[5] = "0001010100111111";
		instructions2[6] = "0001011001111111";
 
		for(int i = 0; i < 7; i++)
		{
			cpu2.registers[i].printBinary(0,1);
		}
		System.out.println();
		
		cpu2.preload(instructions2);
		cpu2.run();
		
		
		for(int i = 0; i < 7; i++)
		{
			cpu2.registers[i].printBinary(0,1);
		}

		
		System.out.println("______________________________________________________________________________\n\n");
	}

	public static void runTestInterrupt_0() {

		System.out.println("Test for: Interrupt 0\n");
		System.out.println("\nInterrupt 0: All of the registers will be printed to the screen.\n");

		Computer cpu = new Computer();
		cpu.halted.set(0);

		String[] instructions = new String[1];
		instructions[0] = "0010000000000000";
		
		 
		cpu.preload(instructions);
		cpu.run();
		
		/*
		 * Code Constraint: To be handled later on...
		 * - Uncomment and run code: instructions don't get executed (properly)
		 * - Problem [?]:
		 * 		- currently code isn't made to call preload() more than 1 time [?]
		 */
		
//		String[] instructions2 = new String[4];
//		instructions2[0] = "0001000100000001";
//		instructions2[1] = "0001001100000011";
//		instructions2[2] = "0001011100000111";
//		instructions2[3] = "0010000000000000";
//		cpu.preload(instructions2);
//		cpu.run();
		
		/*---------- End code constraint ----------*/

		System.out.println("______________________________________________________________________________\n\n");

		}
	
	public static void runTestInterrupt_1() {

		System.out.println("Test for: Interrupt 1\n");
		System.out.println("\nInterrupt 1: All 1024 bytes of memory will be printed to the screen.\n");

		Computer cpu = new Computer();
		cpu.halted.set(0);

		String[] instructions = new String[1];
		instructions[0] = "0010000000000001";
		
		 
		cpu.preload(instructions);
		cpu.run();
		

		System.out.println("______________________________________________________________________________\n\n");

		}
	
//	public static void runTestNot() {
//
//		System.out.println("Test for Not: \n");
//
//		Computer cpu = new Computer();
//		cpu.halted.set(0);
//
//		String[] instructions = new String[1];
//		instructions[0] = "0011000100000010";
//		 
//		cpu.preload(instructions);
//		cpu.run();
//
//
//		System.out.println("______________________________________________________________________________\n\n");
//
//		}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
