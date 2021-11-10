package package_Memory_Assembler_Computer;
import package_Multiplier_ALU.*;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class cpu_test2 {

	public static void main(String[] args) {

		cpu_test2 cpu2 = new cpu_test2();
		cpu2.runTests();
		
		
		
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
	
	public static void runTests3() {
		

		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: cpu_test2.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		
		String[] test1 = {"interrupt 0", ""};
		
		Computer c = new Computer();
		
		String[] instructions = c.assm.assemble(test1);
		
		c.halted.set(0);
		c.preload(instructions);
		c.run();
		
	}
	
	
	public static void runTests() {
		

		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: cpu_test2.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		
		String[] test1 = {"jump 4", "move r1 5", "interrupt 0", "halt"};
		
		Computer c = new Computer();
		
		String[] instructions = c.assm.assemble(test1);
		
		c.halted.set(0);
		c.preload(instructions);
		c.run();
		
	}
	
	public static void runTests2() {
		
		
		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: cpu_test2.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		
		
		String[] test1 = {"compare r1 r2", "jump 1", "branch == 2", "branch > 64", "branch >= 128"
							, "branch != 256"};
		
		Computer c = new Computer();
		
		String[] instructions = c.assm.assemble(test1);
		
		for(String s : instructions)
		{
			System.out.println(s);
		}
		
		c.halted.set(0);
		c.preload(instructions);
		c.run();
		
	}

}
