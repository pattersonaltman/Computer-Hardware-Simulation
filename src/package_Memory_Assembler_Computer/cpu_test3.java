package package_Memory_Assembler_Computer;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

import java.util.ArrayList;
import java.util.Random;

import package_Multiplier_ALU.*;



public class cpu_test3 {

	public static void main(String[] args) {


		cpu_test3 cpu3 = new cpu_test3();
		cpu3.runTests();
		
		
		
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
	
	public static void runTests() {
		
		System.out.println("\n\n\n\n\n__________________________________________________________________________________\n");
		System.out.println("Tests for the class: cpu_test3.java");
		System.out.println("__________________________________________________________________________________\n\n\n\n\n");
		
		
		/* Create 6 random numbers (int & String) */
		
		Random rand = new Random();
		int[] intarr = new int[6];
		String[] strarr = new String[6];
		
		for(int i = 0; i < 6; i++)
		{
			intarr[i] = rand.nextInt(100);
			strarr[i] = Integer.toString(intarr[i]);
		}
		
		
		/* Append and create "move" strings to put into registers */
		
		String[] moveinstruc = new String[6];
		moveinstruc[0] = "move r10 ";
		moveinstruc[1] = "move r11 ";
		moveinstruc[2] = "move r12 ";
		moveinstruc[3] = "move r13 ";
		moveinstruc[4] = "move r14 ";
		moveinstruc[5] = "move r15 ";
		
		for(int i = 0; i < 6; i++)
		{
			moveinstruc[i] += strarr[i];
		}
		
		
		/* Create "push" strings to push into memory*/
		
		String[] pushinstruc = new String[6];
		pushinstruc[0] = "push r10";
		pushinstruc[1] = "push r11";
		pushinstruc[2] = "push r12";
		pushinstruc[3] = "push r13";
		pushinstruc[4] = "push r14";
		pushinstruc[5] = "push r15";
		
		
		/* Create "pop" strings to pop from memory back into registers */
		
		String[] popinstruc = new String[6];
		popinstruc[0] = "pop r5";
		popinstruc[1] = "pop r4";
		popinstruc[2] = "pop r3";
		popinstruc[3] = "pop r2";
		popinstruc[4] = "pop r1";
		popinstruc[5] = "pop r0";
		
			
		/* Add all instructions for move, push, pop into testSet */
		
		 String[] testSet = new String[57];
		 for(int i = 0; i < 6; i++)
		 {
			 testSet[i] = moveinstruc[i];
			 testSet[i+6] = pushinstruc[i];
			 testSet[i+12] = popinstruc[i];
		 }
		 
		 
		 /* Add, subtract, multiply instructions for registers r0 - r5, results placed in r6 - r8 */
		 
		 testSet[18] = "add r0 r1 r6";
		 testSet[19] = "subtract r2 r3 r7";
		 testSet[20] = "multiply r4 r5 r8";
		 
		 
		 /* Any further instructions to add to testSet */
		 
		 testSet[21] = "interrupt 0";
		 testSet[22] = "call 100";		//, pushes address PC = 46 and jumps to address 100 - would be at testSet[50]
		 testSet[23] = "interrupt 0";
		 testSet[24] = "halt";			//halts the CPU, registers r10-r15 have been changed back to 0 from their initial values
		 testSet[50] = "move r10 0";
		 testSet[51] = "move r11 0";
		 testSet[52] = "move r12 0";
		 testSet[53] = "move r13 0";
		 testSet[54] = "move r14 0";
		 testSet[55] = "move r15 0";
		 testSet[56] = "return";		//returns back to testSet[23] (PC = 46)
		 
		 for(int i = 25; i <= 49; i++)
		 {
			 testSet[i] = "interrupt 1";	// interrupt 1 instructions are skipped over - otherwise all memory would be printed
		 }
		 
		 
		 /* Print out instructions, random values, and registers (for checking) */
		 
		 System.out.println("Instructions: \n");
		 
		 int j = 0;
		 for(String s : testSet)
		 {
			 System.out.print(s);
			 System.out.print("\t");
			 j++;
			 if(j % 5 == 0)
			 {
				 System.out.println();
			 }
		 }
		 System.out.println("\n\n");
		 
		 
		 Computer c = new Computer();
		 c.halted.set(0);
		 String[] instrucs = c.assm.assemble(testSet);
		 
		 c.preload(instrucs);
		 c.run();
		 
		 System.out.println("\n");
		 for(int i = 0; i < c.registers.length; i++)
		 {
			 System.out.println("Register "+i+ ": "+c.registers[i].getSigned());
		 }
		 
	}
	

}
