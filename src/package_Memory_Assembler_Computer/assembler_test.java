package package_Memory_Assembler_Computer;

import package_Multiplier_ALU.ALU_test;
import package_Multiplier_ALU.multiplier_test;
import package_RippleAdder.rippleAdder_test;
import package_bit.bit_test;
import package_longword.longword_test;

public class assembler_test {

	public static void main(String[] args) {

		assembler_test assm = new assembler_test();
		assm.runTests();
		
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
		System.out.println("Tests for the class: assembler_test.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		runTestAll();
		
	}
	
	public static void runTestAll() {
		
		String[] instructions = {"and r1 r2 r3", "or r2 r3 r4", "xor r1 r2 r3", "not r5 r6", "leftshift r1 8 r2", 
				"rightshift r3 15 r8", "add r1 r2 r3", "subtract r2 r3 r4", "multiply r1 r2 r3", "halt", "move r9 32", 
				"interrupt 0", "interrupt 1"};

		Assembler a = new Assembler();
		
		String[] bits = a.assemble(instructions);

		for(int i = 0; i < instructions.length; i++)
		{
			System.out.println(instructions[i]);
		}
		System.out.println("\n\n");
		
		for(int i = 0; i < bits.length; i++)
		{
			System.out.println(bits[i]);
		}
		
	}

}
