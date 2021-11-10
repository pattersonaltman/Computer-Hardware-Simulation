package package_Memory_Assembler_Computer;
import package_Multiplier_ALU.*;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class Memory {
	
	bit[] storage;
	
	/* Constructors */
	
	public Memory() {		//default constructor
		this.storage = new bit[8192];				//set to 8192 bits (1024 bytes) by default
		for(int i = 0; i < storage.length; i++)
		{
			storage[i] = new bit();
		}
	}
	
	public Memory(int bits) {
		
		this.storage = new bit[bits];
		
//		for(bit b : this.storage)      /* Not usable: causes NullPointerException - why does it not successfully initialize? */
//		{
//			b = new bit();
//		}
		
		for(int i = 0; i < storage.length; i++)
		{
			storage[i] = new bit();
		}
	}

	public static void main(String[] args) {

		Memory m = new Memory();
		m.printMem(7);
		 
		
	}
	
	public longword read(longword address) {
		
		/*
		 * - Convert longword address to its decimal value - this is the address number to be accessed
		 * 	 in the bit array.
		 * - Address of the bit array ranges from:
		 * 		(address * 8)-th bit to the ((address * 8) + 31)-th bit
		 * - read bit values into new longword
		 * - return longword
		 */
		
		int indexBeg = (address.getSigned() * 8);	//beginning index in memory's bit array
		int indexEnd = indexBeg + 31;				//end index in memory's bit array

		longword value = new longword();
		for(int i = indexBeg; i <= indexEnd; i++)
		{
			value.lw[i - indexBeg].set(storage[i].getValue());		//set value's bit to the value of storage's corresponding bit
		}
		
		return value;
	}
	
	public void write(longword address, longword value) {
		
		/*
		 * - Convert longword address to its decimal value - this is the address number to be accessed
		 * 	 in the bit array.
		 * - Address of the bit array ranges from:
		 * 		(address * 8)-th bit to the ((address * 8) + 31)-th bit
		 * - For every bit in the address range in storage, set it's value to the corresponding bit in longword value
		 */

		int indexBeg = (address.getSigned() * 8);	//beginning index in memory's bit array
		int indexEnd = indexBeg + 31;				//end index in memory's bit array
		
		for(int i = indexBeg; i <= indexEnd; i++)
		{
			storage[i].set(value.lw[i - indexBeg].getValue());		//set storage's bit to the value of value's corresponding bit
		}
		
	}
	
	
	
	
	/*
	 * Extra / Helper methods
	 */
	
	public int getMaxAddress() {
		
		/*
		 * Returns the highest storage address available for the size of the storage.
		 * 
		 * - get size of storage
		 * - Max address = (storage length - 31) / 8
		 */
		
		int max = ((this.storage.length - 31)/8);	//because it is an int - it is automatically rounded down
		return max;
	}
	
	public void printMem() {
		
		/*
		 * Prints the memory array with row numbers
		 * 
		 * - int columns: specifies the number of columns of bytes to print per line
		 */
		
		int columns = 4;
		int j = 0;
		int k = 0;
		int row = 0;
		for(int i = 0; i < storage.length; i++)
		{
			if(j == 0 && k == 0)
			{
				if(row >= 0 && row <= 9)
				{
					System.out.print("[Row "+row+"]     ");
				}
				else if(row >= 10 && row <= 99)
				{
					System.out.print("[Row "+row+"]    ");
				}
				else if(row >= 100 && row <= 999)
				{
					System.out.print("[Row "+row+"]   ");
				}
				else if(row >= 1000 && row <= 9999)
				{
					System.out.print("[Row "+row+"]  ");
				}
				else
				{
					System.out.print("[Row "+row+"] ");
				}
			}
			
			System.out.print(storage[i].getValue());
			j++;
			k++;
			
			if(j == 8 && k == columns * 8) 
			{
				j = 0;
				k = 0;
				row++;
				System.out.println();
			}
			else if(j == 8)
			{
				System.out.print("-");
				j = 0;
			}
		}
	}
	
	public void printMem(int columns) {
		
		/*
		 * Prints the memory array with row numbers
		 * 
		 * - int columns: specifies the number of columns of bytes to print per line
		 */
		
		int j = 0;
		int k = 0;
		int row = 0;
		for(int i = 0; i < storage.length; i++)
		{
			if(j == 0 && k == 0)
			{
				if(row >= 0 && row <= 9)
				{
					System.out.print("[Row "+row+"]     ");
				}
				else if(row >= 10 && row <= 99)
				{
					System.out.print("[Row "+row+"]    ");
				}
				else if(row >= 100 && row <= 999)
				{
					System.out.print("[Row "+row+"]   ");
				}
				else if(row >= 1000 && row <= 9999)
				{
					System.out.print("[Row "+row+"]  ");
				}
				else
				{
					System.out.print("[Row "+row+"] ");
				}
			}
			
			System.out.print(storage[i].getValue());
			j++;
			k++;
			
			if(j == 8 && k == columns * 8) 
			{
				j = 0;
				k = 0;
				row++;
				System.out.println();
			}
			else if(j == 8)
			{
				System.out.print("-");
				j = 0;
			}
		}
	}

}	//end Class Memory







































