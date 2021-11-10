package package_Memory_Assembler_Computer;
import package_Multiplier_ALU.*;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class Assembler {

	public static void main(String[] args) {


//		String s = "16";
//		
//		String i = numToBitString2(s);
		
		
//		char ch = '0';
//		
//		int x = chToNum(ch);
//		
//		System.out.println(x);
		
//		longword l = new longword(15);
//		System.out.println(l.getBinaryStringPartial(8));
		
//		String str = "19";
//		System.out.println(numToBitString2(str, 8));
		
		
	}
	
	public static String[] assemble(String[] instructions) {
		
		String[] bits = new String[instructions.length];
		
		for(int i = 0; i < instructions.length; i++)
		{
			String[] pieces = instructions[i].split(" ");
			String op;
			String r1;
			String r2;
			String r3;
			String amount;
			String num1 = "";
			String num2;
			
			switch(pieces[0])	//pieces[0] holds the operation code for all operations
			{
				case "and":
				case "And":
				case "AND":
					
					//and
					op = "1000";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + r2 + r3;
					
					break;
					
				case "or":
				case "Or":
				case "OR":
					
					//or
					op = "1001";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + r2 + r3;
					
					break;
					
				case "xor":
				case "Xor":
				case "XOR":
					
					//xor
					op = "1010";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + r2 + r3;
					
					break;
					
				case "not":
				case "Not":
				case "NOT":
					
					//not
					op = "1011";
					r1 = registerToBitString(pieces[1]);
					num1 = "0000";
					r3 = registerToBitString(pieces[2]);
					
					bits[i] = op + r1 + num1 + r3;
					
					break;
					
				case "leftshift":
				case "Leftshift":
				case "leftShift":
				case "LEFTSHIFT":
					
					//leftshift
					op = "1100";
					r1 = registerToBitString(pieces[1]);
					num1 = numToBitString(pieces[2], 4);	//arg 2: 4-bit number
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + num1 + r3;
					
					break;
					
				case "rightshift":
				case "Rightshift":
				case "rightShift":
				case "RIGHTSHIFT":
					
					//rightshift
					op = "1101";
					r1 = registerToBitString(pieces[1]);
					num1 = numToBitString(pieces[2], 4);	//arg 2: 4-bit number
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + num1 + r3;
					
					break;
					
				case "add":
				case "Add":
				case "ADD":
					
					//add
					op = "1110";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + r2 + r3;
					
					break;
					
				case "subtract":
				case "Subtract":
				case "SUBTRACT":
					
					//subtract
					op = "1111";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + r2 + r3;
					
					break;
					
				case "multiply":
				case "Multiply":
				case "MULTIPLY":
					
					//multiply
					op = "0111";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					r3 = registerToBitString(pieces[3]);
					
					bits[i] = op + r1 + r2 + r3;
					
					break;
					
				case "halt":
				case "Halt":
				case "HALT":
					
					//halt
					op = "0000";
					num1 = "0000";
					
					bits[i] = op + num1 + num1 + num1;
					
					break;
			
				case "move":
				case "Move":
				case "MOVE":
					
					//move
					op = "0001";
					r1 = registerToBitString(pieces[1]);
					num1 = numToBitString(pieces[2], 8);	//arg 2: 8-bit number
					
					bits[i] = op + r1 + num1;
					
					break;
					
				case "interrupt":
				case "Interrupt":
				case "INTERRUPT":
					
					//interrupt
					
					if(pieces.length == 1)
					{
						switch(pieces[0])
						{
							case "interrupt0":
							case "Interrupt0":
							case "INTERRUPT0":
							case "interrupt-0":
							case "Interrupt-0":
							case "INTERRUPT-0":
								
								//interrupt 0
								op = "0010";
								num1 = "0000";
								
								bits[i] = op + num1 + num1 + num1;
								
								break;
								
							case "interrupt1":
							case "Interrupt1":
							case "INTERRUPT1":
							case "interrupt-1":
							case "Interrupt-1":
							case "INTERRUPT-1":
								
								//interrupt 1
								op = "0010";
								num1 = "0000";
								num2 = "0001";
								
								bits[i] = op + num1 + num1 + num2;
								
								break;
						}
					}
					
					else if(pieces.length == 2)
					{
						switch(pieces[1])
						{
							case "0":
								
								//interrupt 0
								op = "0010";
								num1 = "0000";
								
								bits[i] = op + num1 + num1 + num1;
								
								break;
								
							case "1":
								
								//interrupt 1
								op = "0010";
								num1 = "0000";
								num2 = "0001";
								
								bits[i] = op + num1 + num1 + num2;
								
								break;
						}
					}
					
					break;
					
				case "jump":
				case "Jump":
				case "JUMP":
					
					//jump
					op = "0011";
					num1 = numToBitString(pieces[1], 12);
					
					bits[i] = op + num1;
					
					break;
					
				case "compare":
				case "Compare":
				case "COMPARE":
					
					//compare
					op = "0100";
					num1 = "0000";
					r1 = registerToBitString(pieces[1]);
					r2 = registerToBitString(pieces[2]);
					
					bits[i] = op + num1 + r1 + r2;
					
					break;
					
				case "branch":
				case "Branch":
				case "BRANCH":
					
					//branch
					op = "0101";
					
					switch(pieces[1])
					{
						case "==":
							
							num1 = "01";
						
							break;
					
						case ">":
							
							num1 = "10";
							
							break;
							
						case ">=":
							
							num1 = "11";
							
							break;
							
						case "!=":
							
							num1 = "00";
							
							break;
							
					}
					
					num2 = numToBitString(pieces[2], 10);
					
					bits[i] = op + num1 + num2;
					
					break;
					
				case "push":
				case "Push":
				case "PUSH":
					
					//push
					op = "011000";
					num1 = "000000";
					num2 = registerToBitString(pieces[1]);
					
					bits[i] = op + num1 + num2;
					
					break;
					
				case "pop":
				case "Pop":
				case "POP":
					
					//pop
					op = "011001";
					num1 = "000000";
					num2 = registerToBitString(pieces[1]);
					
					bits[i] = op + num1 + num2;
					
					break;
					
				case "call":
				case "Call":
				case "CALL":
					
					//call
					op = "011010";
					num1 = numToBitString(pieces[1], 10);
					
					bits[i] = op + num1;
					
					break;
					
				case "return":
				case "Return":
				case "RETURN":
					
					//return
					op = "011011";
					num1 = "0000000000";
					
					bits[i] = op + num1;
					
					break;
			}
		}
		
		
		return bits;
	}
	
	
	/*
	 * Helper Methods:
	 * 		- String registerToBitString(String regString)
	 * 		- int isNumber(char c)
	 * 
	 * 
	 * - String registerToBitString(String regString) - takes a String argument that is intended to be
	 * 													to be a register (0-15), and converts it to its
	 * 													respective bit pattern as a String.
	 * 
	 * - int isNumber(char c) - takes char c and checks if it is a number from 0-9. Returns 1 if
	 * 	 						true, 0 if false.
	 */
	
	
	public static String registerToBitString(String regString) {
		
		/*
		 * Method limitation:
		 * 	- Assumes that a String argument is passed in of the form:  __#
		 * 	  Where # will denote the first digit (0-9) recognized. "__" denotes any other characters
		 *    that can come before the digit. No non-digit characters can come after the first recognized
		 *    digit.
		 */
		
		
		
		/* Loop through regString until the first digit is reached */
		
		int i = 0;
		while(isNumber(regString.charAt(i)) == 0)
		{
			i++;	// do nothing, increment through
		}
		//int i is now the value of the index of the first digit
		
		
		/* Convert rest of regString to its bit pattern - (the rest of regString is the register value) */
		
		String value = "";
		String bitPattern = "";
		
		for(int index = i; index < regString.length(); index++)
		{
			value += regString.charAt(index);	//regString is parsed to its register value
		}
		
		switch(value)	//assign the corresponding bit pattern for the register (0-15)
		{
			case "0":
				bitPattern = "0000";
				break;
				
			case "1":
				bitPattern = "0001";
				break;
				
			case "2":
				bitPattern = "0010";
				break;
				
			case "3":
				bitPattern = "0011";
				break;
				
			case "4":
				bitPattern = "0100";
				break;
				
			case "5":
				bitPattern = "0101";
				break;
				
			case "6":
				bitPattern = "0110";
				break;
				
			case "7":
				bitPattern = "0111";
				break;
				
			case "8":
				bitPattern = "1000";
				break;
				
			case "9":
				bitPattern = "1001";
				break;
				
			case "10":
				bitPattern = "1010";
				break;
				
			case "11":
				bitPattern = "1011";
				break;
				
			case "12":
				bitPattern = "1100";
				break;
				
			case "13":
				bitPattern = "1101";
				break;
				
			case "14":
				bitPattern = "1110";
				break;
				
			case "15":
				bitPattern = "1111";
				break;
		}
		
		return bitPattern;
	}
	
	public static String numToBitString(String numString, int length) {
				
		int value = Integer.valueOf(numString);
		longword l = new longword(value);
	
		String bits = "";
		
		for(int i = (l.lw.length - length); i < l.lw.length; i++)
		{
			if(l.lw[i].getValue() == 0)
			{
				bits += '0';
			}
			else if(l.lw[i].getValue() == 1)
			{
				bits += '1';
			}
		}
		
		return bits;
	}
	
	public static int isNumber(char c) {
		
		if(c == '0' || c == '1' || c == '2' ||  c == '3' ||  c == '4' ||  c == '5' ||  c == '6' || 
				 c == '7' ||  c == '8' ||  c == '9')
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static int exponent(int base, int power) {
		
		/*
		 * Method Constraints:
		 * 	- Does not account for negative powers.
		 */
		
		if(base == 0)
		{
			return 0;
		}
		
		if(power == 0)
		{
			return 1;
		}
		else
		{
			int value = base;
			
			for(int i = 1; i < power; i++)
			{
				value *= base;
			}
			return value;
		}
	}
	
	public static int chToNum(char digit) {
		
		int val = 0;
		
		if(digit == '0')
		{
			longword l = new longword(0);
			val = l.getSigned();
		}
		else if(digit == '1')
		{
			longword l = new longword(1);
			val = l.getSigned();
		}
		else if(digit == '2')
		{
			longword l = new longword(2);
			val = l.getSigned();
		}
		else if(digit == '3')
		{
			longword l = new longword(3);
			val = l.getSigned();
		}
		else if(digit == '4')
		{
			longword l = new longword(4);
			val = l.getSigned();
		}
		else if(digit == '5')
		{
			longword l = new longword(5);
			val = l.getSigned();
		}
		else if(digit == '6')
		{
			longword l = new longword(6);
			val = l.getSigned();
		}
		else if(digit == '7')
		{
			longword l = new longword(7);
			val = l.getSigned();
		}
		else if(digit == '8')
		{
			longword l = new longword(8);
			val = l.getSigned();
		}
		else if(digit == '9')
		{
			longword l = new longword(9);
			val = l.getSigned();
		}
		
		
		return val;
	}
	
	public static String numToBitString2(String numString, int length) {
				
		String bin;
		int value = 0;
		
		for(int i = 0; i < numString.length(); i++)
		{
			value += (chToNum(numString.charAt(i)) * (exponent(10, (numString.length() - 1) - i)));
		}
		
		longword l = new longword(value);
		bin = l.getBinaryStringPartial(length);
		
		return bin;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
