package package_Memory_Assembler_Computer;
import package_Multiplier_ALU.*;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class Computer {

	/* Members */
		
		/* Assignment members */
	
	 bit halted;									// 0 = running, 1 = halted
	private Memory mem;									// memory
	private longword PC;								// program counter
	 longword[] registers = new longword[16];	// registers - size: 16 longwords
	private longword currentInstruction;				// current instruction
	private longword op1;								// operand 1 (R1)
	private longword op2;								// operand 2 (R2)
	private longword result;							// result (R3)
	private bit[] compareResult = new bit[2];			/* 2-bit result for the compare instruction, 
														   bit[0] = 1 if positive 0 if not, bit[1] = 1 if equal, 0 if not */
	ALU alu;											// ALU
	Assembler assm;										// Assembler
	private longword SP;								//stack pointer
	
	
		/* Other members (if any) */
	
	
	/* Constructors */
	
	public Computer() {
		halted = new bit(1);					//default value 1 = halted
		mem = new Memory();						//default memory size: 8192 bits / 1024 bytes
		PC = new longword();					//default value: 0
		for(int i = 0; i < registers.length; i++)		
		{
			registers[i] = new longword();		//initialize all longwords, Value: 0
		}
		currentInstruction = new longword();
		op1 = new longword();
		op2 = new longword();
		result = new longword();
		for(int i = 0; i < compareResult.length; i++)
		{
			compareResult[i] = new bit();
		}
		alu = new ALU();
		assm = new Assembler();
		SP = new longword(1020);				//initialize value: 1020 - since max addresses = 1020
	}
	
	public Computer(int memBits) {
		halted = new bit(1);					//default value 1 = halted
		mem = new Memory(memBits);				//customizable memory size
		PC = new longword();					//default value: 0
		for(int i = 0; i < registers.length; i++)		
		{
			registers[i] = new longword();		//initialize all longwords, Value: 0
		}
		currentInstruction = new longword();
		op1 = new longword();
		op2 = new longword();
		result = new longword();
		for(int i = 0; i < compareResult.length; i++)
		{
			compareResult[i] = new bit();
		}
		alu = new ALU();
		assm = new Assembler();
		SP = new longword(1020);				//initialize value: 1020 - since max addresses = 1020
	}
	
	public static void main(String[] args) {



		
		
		
		
	}
	
	public void run() {
		
		while(halted.getValue() == 0)
		{
			fetch();
			decode();
			execute();
			store();
		}
		
	}

	public void fetch() {
	
		RippleAdder rip = new RippleAdder();
		
		currentInstruction = mem.read(PC);		//read current instruction from memory
		PC = rip.add(PC, new longword(2));		//increment program counter by 2
		
	}
	
	public void decode() {
		
		/*---------------- Halt: return ----------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*------------------ End Halt ------------------*/
		
		/*---------------- Move: return ----------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						return;
					}
				}
			}
		}
		
		/*------------------ End Move ------------------*/
		
		/*---------------- Interrupt: return ----------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*------------------ End Interrupt ------------------*/
		
		/*------------------ Jump: return ------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						return;
					}
				}
			}
		}
		
		/*-------------------- End Jump --------------------*/
		
		/*-------------------- Compare: return --------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*---------------------- End Compare ----------------------*/
		
		/*-------------------- Branch: return --------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						return;
					}
				}
			}
		}
		
		/*---------------------- End Branch ----------------------*/
		
		/*---------------------- Push/Pop/Call/Return: return ----------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*---------------------- End Push/Pop/Call/Return ----------------------*/
		
		
		
		
		bit b = new bit(1);
		
		/* Set op1 for R1 */
		
		longword temp = new longword();
		for(int i = 4; i <= 7; i++)
		{
			temp.setBit(i, b);					// set temp's bits to 1 for bits: 4,5,6,7
		}
		temp = currentInstruction.and(temp);	// mask all temp's bits except bits: 4,5,6,7
		temp = temp.rightShift(24);				/* right shift temp by 24 - unmasked bits are now at indices: 28-31.
		 										   temp is the value of the index of R1 */
		op1.copy(registers[temp.getSigned()]);	// copy R1 to op1
		
		/* Set op2 for R2 */
		
		temp.set(0);							// reset temp
		for(int i = 8; i <= 11; i++)
		{
			temp.setBit(i, b);					// set temp's bits to 1 for bits: 8,9,10,11	
		}
		temp = currentInstruction.and(temp);	// mask all temp's bits except bits: 8,9,10,11
		temp = temp.rightShift(20);				/* right shift temp by 20 - unmasked bits are now at indices: 28-31.
		   										   temp is the value of the index of R2 */
		op2.copy(registers[temp.getSigned()]);	// copy R2 to op2
		
	}
	
	public void execute() {
		
		/* -------------- Halt: Handle | return -------------- */
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						halted.set(1);		//set halted to 1
						return;
					}
				}
			}
		}
		/*----------------------- End Halt -----------------------*/
		
		/* -------------- Move: Handle | return -------------- */
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						// Operation is Move
						// Set result to the value to be moved
						
						longword temp = new longword();
						bit b = new bit(1);
						
						for(int i = 8; i <= 15; i++)
						{
							temp.setBit(i, b);					// set temp's bits to 1 for bits: 8-15	
						}
						temp = currentInstruction.and(temp);	// mask all temp's bits except bits: 8-15
						temp = temp.rightShift(16);				// temp is now at indices: 23-31, and equals the value to be moved 
						result.copy(temp);						//copy temp into result to be stored
						
						return;
					}
				}
			}
		}
		/*----------------------- End Move -----------------------*/
		
		/*---------------- Interrupt: Handle | return ----------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						/* Interrupt: 0 - print all registers to the screen */
						
						if(currentInstruction.lw[12].getValue() == 0)
						{
							if(currentInstruction.lw[13].getValue() == 0)
							{
								if(currentInstruction.lw[14].getValue() == 0)
								{
									if(currentInstruction.lw[15].getValue() == 0)
									{
										for(int i = 0; i < registers.length; i++)
										{
											registers[i].printBinary(0,1);		//printBinary(newlines before, newlines after)
										}
										System.out.println();
									}
								}
							}
						}
						
						/* Interrupt: 1 - print all 1024 bytes of memory */
						
						if(currentInstruction.lw[12].getValue() == 0)
						{
							if(currentInstruction.lw[13].getValue() == 0)
							{
								if(currentInstruction.lw[14].getValue() == 0)
								{
									if(currentInstruction.lw[15].getValue() == 1)
									{
										mem.printMem();
									}
								}
							}
						}
						
						return;
					}
				}
			}
		}
		
		/*------------------- End Interrupt -------------------*/
		
		/*------------------ Jump: return ------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						return;
					}
				}
			}
		}
		
		/*-------------------- End Jump --------------------*/
		
		/*-------------------- Compare: return --------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*---------------------- End Compare ----------------------*/
		
		/*-------------------- Branch: return --------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						return;
					}
				}
			}
		}
		
		/*---------------------- End Branch ----------------------*/
		
		/*---------------------- Push/Pop/Call/Return: return ----------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*---------------------- End Push/Pop/Call/Return ----------------------*/
		
		

		
		ALU alu = new ALU();
		bit[] operation = new bit[4];		//operation to be done - as a bit array
		
		for(int i = 0; i < 4; i++)
		{
			operation[i] = new bit();									//initialize bit array
			operation[i].set(currentInstruction.lw[i].getValue());		//set operation to the operation code in currentInstruction
		}
		
		result = alu.doOp(operation, op1, op2);		//calculate result from currentInstruction: [operation] [R1] [R2] [R3]
		
	}
	
	public void store() {

		/* ----------------- Halt: return ----------------- */

		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;		//halted already set, do not store anything, exit
					}
				}
			}
		}
		/*----------------------- End Halt -----------------------*/
		
		/* --------------- Move: Handle | return --------------- */
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						// Operation is Move
						// Store result in the register specified
						
						bit b = new bit(1);
						longword temp = new longword();
						
						for(int i = 4; i <= 7; i++)
						{
							temp.setBit(i,  b);					//set bits: 4-7
						}
						
						temp = currentInstruction.and(temp);	//mask temp, except: 4-7
						temp = temp.rightShift(24);				//move temp to indices: 27-31, temp is the value of the register index
						
						registers[temp.getSigned()].copy(result);	//Move result into the specified register
												
						return;
					}
				}
			}
		}
		/*----------------------- End Move -----------------------*/
		
		/*----------------- Interrupt: return -----------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						return;
					}
				}
			}
		}
		
		/*------------------- End Interrupt -------------------*/
		
		/*------------------ Jump: Handle | return ------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 0)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						/*
						 * Jump to instruction at the specified address.
						 * 	- copy currentInstruction to PC, to get the specified address
						 * 	- currentInstruction is defined in the first half of the longword, 
						 *    and PC needs to be defined in the 2nd half, so right shift by 16
						 * 	  to move to the 2nd half.
						 * 	- clear the op code bits at indices 16-19
						 * 	- PC is now the value of the specified address
						 */
						PC.copy(currentInstruction);
						PC = PC.rightShift(16);
						for(int i = 16; i <= 19; i++)
						{
							PC.lw[i].set(0);
						}
						return;
					}
				}
			}
		}
		
		/*-------------------- End Jump --------------------*/
		
		/*-------------------- Compare: Handle | return --------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						/*
						 * Compare Rx and Ry
						 * 	- set op1 to Rx, set op2 to Ry
						 *  - call alu, subtract(op1, op2)
						 *  - set compareResult based on subtraction result
						 *  	- if positive: set to 10
						 *  	- if negative: set to 00
						 *  	- if equal:    set to 01
						 */
						
						/* Set op1 for Rx */
						
						longword temp = new longword();
						for(int i = 8; i <= 11; i++)
						{
							temp.setBit(i, new bit(1));
						}

						temp = currentInstruction.and(temp);
						temp = temp.rightShift(20);
						
						op1.copy(registers[temp.getSigned()]);
						
						/* Set op2 for Ry */
						
						temp.set(0);
						for(int i = 12; i <= 15; i++)
						{
							temp.setBit(i, new bit(1));
						}
						
						temp = currentInstruction.and(temp);
						temp = temp.rightShift(16);
						
						op2.copy(registers[temp.getSigned()]);
						
						/* Subtract(op1, op2) */
						
						bit[] operation = {new bit(1), new bit(1), new bit(1), new bit(1)};
						
						result = alu.doOp(operation, op1, op2);
						
						/* Set 2-bit compareResult based on positive, negative, equal */
						
						if(result.lw[0].getValue() == 0 && result.getSigned() != 0)		//difference is positive (Rx > Ry)
						{
							compareResult[0].set(1);
							compareResult[1].set(0);
						}
						if(result.lw[0].getValue() == 1)								//difference is negative (Rx < Ry)
						{
							compareResult[0].set(0);
							compareResult[1].set(0);
						}
						if(result.lw[0].getValue() == 0 && result.getSigned() == 0)		//difference is zero (Rx = Ry)
						{
							compareResult[0].set(0);
							compareResult[1].set(1);
						}
						
						return;
					}
				}
			}
		}
		
		/*---------------------- End Compare ----------------------*/
		
		/*-------------------- Branch: Handle | return --------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 0)
				{
					if(currentInstruction.lw[3].getValue() == 1)
					{
						/*
						 * 
						 */
						
						/* Get branchCode (type of branch/comparison to be done) from currentInstruction */
						
						bit[] branchCode = {new bit(), new bit()};
						
						branchCode[0].set(currentInstruction.lw[4].getValue());
						branchCode[1].set(currentInstruction.lw[5].getValue());
						
						/* Branch based on branch code */
						
						if(branchCode[0].getValue() == 0 && branchCode[1].getValue() == 1)
						{
							//BranchIfEqual
							
							/* Do ==  - Check if compareResult is equal (01) */
							
							if(compareResult[0].getValue() == 0 && compareResult[1].getValue() == 1)
							{
								//x is equal to y
								
								/* Do sign-extended Jump (offset) */
								
								longword offset = new longword();
								
								offset.copy(currentInstruction);
								offset = offset.rightShift(16);
								
								longword temp = new longword();
								for(int i = 22; i <= 31; i++)
								{
									temp.setBit(i, new bit(1));
								}
								
								offset = offset.and(temp);
								
								//add/subtract the offset for PC
								
								if(currentInstruction.lw[6].getValue() == 0)
								{
									//add offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(0)};
									
									PC = alu.doOp(op, PC, offset);
								}
								if(currentInstruction.lw[6].getValue() == 1)
								{
									//subtract offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(1)};
									
									PC = alu.doOp(op, PC, offset);
								}
							}
							
						}
						
						if(branchCode[0].getValue() == 1 && branchCode[1].getValue() == 0)
						{
							//BranchIfGreaterThan
							
							/* Do >  - Check if compareResult is positive (10) */
							
							if(compareResult[0].getValue() == 1 && compareResult[1].getValue() == 0)
							{
								//x is greater than y
								
								/* Do sign-extended Jump (offset) */
								
								longword offset = new longword();
								
								offset.copy(currentInstruction);
								offset = offset.rightShift(16);
								
								longword temp = new longword();
								for(int i = 22; i <= 31; i++)
								{
									temp.setBit(i, new bit(1));
								}
								
								offset = offset.and(temp);
								
								//add/subtract the offset for PC
								
								if(currentInstruction.lw[6].getValue() == 0)
								{
									//add offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(0)};
									
									PC = alu.doOp(op, PC, offset);
								}
								if(currentInstruction.lw[6].getValue() == 1)
								{
									//subtract offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(1)};
									
									PC = alu.doOp(op, PC, offset);
								}
							}
							
						}
						
						if(branchCode[0].getValue() == 1 && branchCode[1].getValue() == 1)
						{
							//BranchIfGreaterThanOrEqual
							
							/* Do >=  - Check if compareResult is positive OR is equal (01) || (10) */
							
							if(compareResult[0].getValue() == 0 && compareResult[1].getValue() == 1 
								|| compareResult[0].getValue() == 1 && compareResult[1].getValue() == 0)
							{
								//x is greater than or equal to y
								
								/* Do sign-extended Jump (offset) */
								
								longword offset = new longword();
								
								offset.copy(currentInstruction);
								offset = offset.rightShift(16);
								
								longword temp = new longword();
								for(int i = 22; i <= 31; i++)
								{
									temp.setBit(i, new bit(1));
								}
								
								offset = offset.and(temp);
								
								//add/subtract the offset for PC
								
								if(currentInstruction.lw[6].getValue() == 0)
								{
									//add offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(0)};
									
									PC = alu.doOp(op, PC, offset);
								}
								if(currentInstruction.lw[6].getValue() == 1)
								{
									//subtract offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(1)};
									
									PC = alu.doOp(op, PC, offset);
								}
							}
							
						}
						
						if(branchCode[0].getValue() == 0 && branchCode[1].getValue() == 0)
						{
							//BranchIfNotEqual
							
							/* Do !=  - Check if compareResult is positive OR is negative (10) || (00) */
							
							if(compareResult[0].getValue() == 1 && compareResult[1].getValue() == 0 
								|| compareResult[0].getValue() == 0 && compareResult[1].getValue() == 0)
							{
								//x is not equal to y
								
								/* Do sign-extended Jump (offset) */
								
								longword offset = new longword();
								
								offset.copy(currentInstruction);
								offset = offset.rightShift(16);
								
								longword temp = new longword();
								for(int i = 22; i <= 31; i++)
								{
									temp.setBit(i, new bit(1));
								}
								
								offset = offset.and(temp);
								
								//add/subtract the offset for PC
								
								if(currentInstruction.lw[6].getValue() == 0)
								{
									//add offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(0)};
									
									PC = alu.doOp(op, PC, offset);
								}
								if(currentInstruction.lw[6].getValue() == 1)
								{
									//subtract offset
									
									bit[] op = {new bit(1), new bit(1), new bit(1), new bit(1)};
									
									PC = alu.doOp(op, PC, offset);
								}
							}
							
						}
						
						return;
						
					}
				}
			}
		}
		
		/*-------------------------- End Branch ---------------------------*/
		
		/*---------------------- Push/Pop/Call/Return: Handle | return ----------------------*/
		
		if(currentInstruction.lw[0].getValue() == 0)
		{
			if(currentInstruction.lw[1].getValue() == 1)
			{
				if(currentInstruction.lw[2].getValue() == 1)
				{
					if(currentInstruction.lw[3].getValue() == 0)
					{
						/* ---------- Push ---------- */
						
						if(currentInstruction.lw[4].getValue() == 0)
						{
							if(currentInstruction.lw[5].getValue() == 0)
							{
								/*
								 * Algorithm:
								 *  - clear opcode: left shift 4
								 *  - move register index value to end: right shift 20
								 *  - copy value at given register into val
								 *  - write val to memory at address SP
								 *  - decrement (subtract) SP by 4
								 *  - return
								 */
								
								longword addr = currentInstruction.leftShift(4);
								addr = addr.rightShift(20);
								
								longword val = new longword();
								val.copy(registers[addr.getSigned()]);
								
								mem.write(SP, val);
								
								bit[] subtract = {new bit(1), new bit(1), new bit(1), new bit(1)};
								SP = alu.doOp(subtract, SP, new longword(4));
								
								return;
							}
						}
						
						/* -------- End Push -------- */
						
						/* ---------- Pop ---------- */
						
						if(currentInstruction.lw[4].getValue() == 0)
						{
							if(currentInstruction.lw[5].getValue() == 1)
							{
								/*
								 * Algorithm:
								 * 	- increment (add) SP by 4
								 * 	- clear opcode & sub-opcode: left shit 6
								 *  - move register index value to end: right shift 22
								 *  - read from memory at address SP, store in given register
								 *  - return
								 */
								
								bit[] add = {new bit(1), new bit(1), new bit(1), new bit(0)};
								SP = alu.doOp(add, SP, new longword(4));
								
								longword temp = currentInstruction.leftShift(6);
								temp = temp.rightShift(22);
								
								registers[temp.getSigned()] = mem.read(SP);
								
								return;
							}
						}
						
						/* -------- End Pop -------- */
						
						/* ---------- Call ---------- */
						
						if(currentInstruction.lw[4].getValue() == 1)
						{
							if(currentInstruction.lw[5].getValue() == 0)
							{
								/*
								 * Algorithm:
								 * - (push next instruction PC onto stack)
								 *  		- write PC to memory at address SP
								 * - (Jump/Change PC to specified address)
								 *  		- clear opcode & sub-opcode: left shift 6
								 *  		- move Jump address value to end: right shift 22
								 * - decrement (subtract) SP by 4
								 * - return
								 */
								
								mem.write(SP, PC);
								
								PC = currentInstruction.leftShift(6);
								PC = PC.rightShift(22);
								
								bit[] subtract = {new bit(1), new bit(1), new bit(1), new bit(1)};
								SP = alu.doOp(subtract, SP, new longword(4));
								
								return;
							}
						}
						
						/* -------- End Call -------- */
						
						/* ---------- Return ---------- */
						
						if(currentInstruction.lw[4].getValue() == 1)
						{
							if(currentInstruction.lw[5].getValue() == 1)
							{
								/*
								 * Algorithm:
								 *  - increment (add) SP by 4
								 *  (Set PC (Jump) to the instruction address stored in memory at address SP)
								 *  	- PC = mem.read(SP)
								 *  - return
								 */
								
								bit[] add = {new bit(1), new bit(1), new bit(1), new bit(0)};
								SP = alu.doOp(add, SP, new longword(4));
								
								PC = mem.read(SP);
								
								return;
							}
						}
						
						/* -------- End Return -------- */
					}
				}
			}
		}
		
		/*---------------------- End Push/Pop/Call/Return ----------------------*/
		
		
		
		
		bit b = new bit(1);
		longword temp = new longword();
		
		for(int i = 12; i < 16; i++)
		{
			temp.setBit(i, b);						//set bits: 12,13,14,15 to 1
		}
		
		temp = currentInstruction.and(temp);		//mask temp - except for: 12,13,14,15
		temp = temp.rightShift(16);					/* right shift temp by 16 - unmasked bits are now at indices: 28-31.
		 											   temp is the value of the index of R3 */

		registers[temp.getSigned()].copy(result);		//copy result into R3
	
	}
	
	
	public void preload(String[] instructions) {
		
		longword address = new longword();		//address starts at 0
		bit b0 = new bit(0);					//bit for setting: value 0
		bit b1 = new bit(1);					//bit for setting: value 1
		RippleAdder rip = new RippleAdder();	//rippleadder to increment longword address
		longword lwFour = new longword(4);
		
		
		String s1 = "";						//instruction 1
		String s2 = "";						//instruction 2
		String s3 = "";						//Full longword (String): s1 + s2
		longword value = new longword();	//Full longword: s1 + s2
		
		/*
		 * Pseudo-code:
		 * 
		 * 	for(size of String[] instructions)
		 *	 {
		 * 		if(i == even)
		 * 			put first instruction in string 1
		 * 		if(i == odd)
		 * 			put second instruction in string 2
		 * 			string 3 = string 1 + string 2
		 * 			change longword value to string 3
		 * 			write to memory: longword value, at longword address
		 * 			increment longword address by 4
		 *	 }
		 *
		 *	if(String[] instructions is an odd # length)
		 *		//there is 1 instruction left to process and write
		 *		//can be done be by either:
		 *				- appending the last instruction & a 0-value (would also be Halt operation), 
		 *				  and copying to the longword.
		 *				- Use changeTo(String bin) - puts instruction in the 2nd half of the longword. Left shift
		 *				  by 16 to move it to the 1st half, 2nd half becomes 0's (Halt)
		 *
		 */
		
		for(int i = 0; i < instructions.length; i++)
		{
			if(i % 2 == 0)		
			{
				s1 = instructions[i];
			}
			else if(i % 2 == 1)
			{
				s2 = instructions[i];
				s3 = s1 + s2;
				value.changeTo(s3);						//change value to the String argument
				mem.write(address, value);				//write value to memory
				address = rip.add(address, lwFour);		//increment address by 4
			}
		}
		if(instructions.length % 2 == 1)	//if length of instructions[] is odd
		{
			value.changeTo(s1);					//change value to s1: s1 is the last instruction in the array
			value = value.leftShift(16);		//left shift the instruction to the 1st half of value
			mem.write(address, value);			//write value to memory
		}
	}
	
	
	
}	//end Class Computer




























































