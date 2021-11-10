package package_longword;
import package_bit.bit;

public class longword implements ILongword{

	private static final int SIZE = 32;
	public bit[] lw = new bit[SIZE];
	
	/* Constructors */
	
	public longword() {					//default constructor
		for(int i = 0; i < SIZE; i++)
		{
			this.lw[i] = new bit();			//initialize array
			this.lw[i].set(0);				//set to 0 by default
		}
	}
	
	public longword(int decimalNum) {
		String bin = Integer.toBinaryString(decimalNum);
		int len = bin.length();				//length of significant digits 
		int zeroIndex = (SIZE - len) - 1;	//0-size index of insignificant digits in the binary number
		
		for(int i = 0; i < SIZE; i++)
		{
			this.lw[i] = new bit();				//initialize array
		}
		
		for(int i = 0; i <= zeroIndex; i++)		//set insignificant digits to 0
		{
			this.lw[i].set(0);
		}
		
		int j = 0;
		char val;
		for(int i = (zeroIndex + 1); i < SIZE; i++)		//for most-significant-bit (MSB) index to SIZE... 
		{
			val = bin.charAt(j);								//take value from binary String
			j++;												//increment binary String index
			this.lw[i].set(Character.getNumericValue(val));		//set longword's next MSB to value
		}
	}
	
	public longword(int[] copy) {
		if(copy.length != SIZE)
		{
			System.out.println("\nError: array argument is not a valid size.\nMethod: Constructor - longword(int[] copy)\n");
		}
		else
		{
			for(int i = 0; i < SIZE; i++)
			{
				this.lw[i] = new bit();				//initialize array
			}
			
			for(int i = 0; i < SIZE; i++)
			{
				this.lw[i].set(copy[i]);
			}
		}
	}
	
	
	
	public static void main(String[] args) {



		
		
		
		

		
	}

	@Override
	public bit getBit(int i) {
		if(i >= SIZE)			//check bounds
		{
			System.out.println("\nError: index out of bounds.\nMethod: getBit(int i)\n");
			return null;
		}
		else
		{
			return this.lw[i];		//return index if valid
		}
	}

	@Override
	public void setBit(int i, bit value) {
		if(i >= SIZE)			//check bounds
		{
			System.out.println("\nError: index out of bounds.\nMethod: setBit(int i, bit value)\n");
		}
		else
		{
			this.lw[i].set(value.getValue());		//set index's value if valid
		}
	}

	@Override
	public longword and(longword other) {
		
		int copy[] = new int[SIZE];			//longword copy to pass to constructor
		
		for(int i = 0; i < SIZE; i++)		//create new longword copy for and()
		{
			if(this.lw[i].and(other.lw[i]).getValue() == 1)		//and() returns 1	
			{
				copy[i] = 1;
			}
			else
			{
				copy[i] = 0;				
			}
		}
		
		longword l = new longword(copy);	//make and return new longword
		return l;
	}

	@Override
	public longword or(longword other) {

		int copy[] = new int[SIZE];			//longword copy to pass to constructor
		
		for(int i = 0; i < SIZE; i++)		//create new longword copy for or()
		{
			if(this.lw[i].or(other.lw[i]).getValue() == 1)		//or() returns 1	
			{
				copy[i] = 1;
			}
			else
			{
				copy[i] = 0;				
			}
		}
		
		longword l = new longword(copy);	//make and return new longword
		return l;
	}

	@Override
	public longword xor(longword other) {
		
		int copy[] = new int[SIZE];			//longword copy to pass to constructor
		
		for(int i = 0; i < SIZE; i++)		//create new longword copy for xor()
		{
			if(this.lw[i].xor(other.lw[i]).getValue() == 1)		//xor() returns 1	
			{
				copy[i] = 1;
			}
			else
			{
				copy[i] = 0;				
			}
		}
		
		longword l = new longword(copy);	//make and return new longword
		return l;
	}

	@Override
	public longword not() {

		int copy[] = new int[SIZE];			//longword copy to pass to constructor
		
		for(int i = 0; i < SIZE; i++)		//create new longword copy for not()
		{
			if(this.lw[i].not().getValue() == 1)		//not() returns 1
			{
				copy[i] = 1;
			}
			else
			{
				copy[i] = 0;
			}
		}
		
		longword l = new longword(copy);	//make and return new longword
		return l;
	}

	@Override
	public longword rightShift(int amount) {

		int copy[] = new int[SIZE];
		
		for(int i = 0; i < (SIZE - amount); i++)
		{
			copy[i + amount] = this.lw[i].getValue();
		}
		
		longword l = new longword(copy);
		
		return l; 
	}

	@Override
	public longword leftShift(int amount) {

		int copy[] = new int[SIZE];
		
		for(int i = amount; i < SIZE; i++)
		{
			copy[i - amount] = this.lw[i].getValue();
		}
		
		longword l = new longword(copy);
		
		return l; 
	}
	
public String toString1() {
		
		String bin = "";
		
		for(int i = 0; i < this.lw.length; i++)
		{
			if(this.lw[i].getValue() == 0)
			{
				bin += "0";
			}
			else if(this.lw[i].getValue() == 1) 
			{
				bin += "1";
			}
		}
		return bin;
	}
	
	public String toString2() {
		
		String s = "[";
		
		for(int i = 0; i < SIZE; i++)
		{
			s += Integer.toString(this.lw[i].getValue());
			if(i < (SIZE - 1))
			{
				s += ",";
			}
		}
		s += "]";
		
		return s;
	}

	@Override
	public long getUnsigned() {

		long x = 0;
		double power;		//will be power to raise by, also equal to the respective digit of the binary number
		
		for(int i = 0; i < SIZE; i++) 
		{
			power = (SIZE - 1) - i;					//MSB starts at left (index 0), LSB at right (index 32)
			if(this.lw[i].getValue() == 0)
			{
				x += (0 * Math.pow(2, power));		//current digit is 0
			}
			else
			{
				x += (1 * Math.pow(2, power));		//current digit is 1
			}
		}
		
		return x;
	}

	@Override
	public int getSigned() {

		int x = 0;
		double power;		//will be power to raise by, also equal to the respective digit of the binary number
		
		for(int i = 0; i < SIZE; i++) 
		{
			power = (SIZE - 1) - i;					//MSB starts at left (index 0), LSB at right (index 32)
			if(this.lw[i].getValue() == 0)
			{
				x += (0 * Math.pow(2, power));		//current digit is 0
			}
			else
			{
				x += (1 * Math.pow(2, power));		//current digit is 1
			}
		}
		
		return x;
	}

	@Override
	public void copy(longword other) {

		int copy[] = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++)
		{
			if(other.lw[i].getValue() == 0)
			{
				copy[i] = 0;
			}
			else
			{
				copy[i] = 1;
			}
		}
		
		for(int i = 0; i < SIZE; i++)
		{
			this.lw[i].set(copy[i]);
		}
	}

	@Override
	public void set(int value) {

		String bin = Integer.toBinaryString(value);
		int len = bin.length();				//length of significant digits 
		int zeroIndex = (SIZE - len) - 1;	//0-size index of insignificant digits in the binary number
		
		for(int i = 0; i <= zeroIndex; i++)		//set insignificant digits to 0
		{
			this.lw[i].set(0);
		}
		
		int j = 0;
		char val;
		for(int i = (zeroIndex + 1); i < SIZE; i++)		//for most-significant-bit (MSB) index to SIZE... 
		{
			val = bin.charAt(j);								//take value from binary String
			j++;												//increment binary String index
			this.lw[i].set(Character.getNumericValue(val));		//set longword's next MSB to value
		}
	}
	
	
	
	/*
	 * - The below method are extra methods, not part of the assignment requirements, for the
	 * purpose of making testing more convenient.
	 * 
	 * - They are all methods to print a longword, with the addition of 1 method that
	 * 	 returns the bit[] array of a longword, and 1 method that changes a longword's value.
	 * 
	 * Methods:
	 * 		- void printBinary() - prints the full longword (No newlines added)
	 * 		
	 * 		- void printArray(int[] arr) - prints the array argument (No newlines added)
	 * 								- this is meant to print the bit[] array - obtained from int[] getBinary()
	 * 		
	 * 		- int[] getBinary() - returns the bit[] array of a longword
	 * 		
	 * 		- void printBinary(int newlinesBefore, int newlinesAfter) - same method as printBinary()
	 * 		  but it adds newlines before and after
	 * 
	 * 		- void printArray(int[] arr, int newlinesBefore, int newlinesAfter) - same method as
	 * 		  printArray(int[] arr), but it adds newlines before and after
	 * 
	 * 		- void changeTo(String bin) - sets a longword to the value specified by the String bin
	 * 									- String bin is intended to be entered as a binary number value
	 */
	
	public void printBinary() {
		
		for(int i = 0; i < this.lw.length; i++)
		{
			System.out.print(this.lw[i].getValue());
		}
	}
	
	public void printArray(int[] arr) {
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]);
		}
	}
	
	public int[] getBinary() {
		
		int[] bin = new int[this.lw.length];
		
		for(int i = 0; i < this.lw.length; i++)
		{
			bin[i] = this.lw[i].getValue();
		}
		return bin;
	}
	
	
	public String getBinaryStringPartial(int length) {
		
		int index = this.lw.length - length;	//index = start index for the binary string, based on length
		String bin = "";
		
		for(int i = index; i < this.lw.length; i++)
		{
			if(this.lw[i].getValue() == 0)
			{
				bin += "0";
			}
			else if(this.lw[i].getValue() == 1) 
			{
				bin += "1";
			}
		}
		return bin;
	}
	
	
public void printBinary(int newlinesBefore, int newlinesAfter) {
		
		for(int i = 0; i < newlinesBefore; i++)
		{
			System.out.println();
		}
	
		for(int i = 0; i < this.lw.length; i++)
		{
			System.out.print(this.lw[i].getValue());
		}
		
		for(int i = 0; i < newlinesAfter; i++)
		{
			System.out.println();
		}
	}

public void printArray(int[] arr, int newlinesBefore, int newlinesAfter) {
	
	for(int i = 0; i < newlinesBefore; i++)
	{
		System.out.println();
	}
	
	for(int i = 0; i < arr.length; i++)
	{
		System.out.print(arr[i]);
	}
	
	for(int i = 0; i < newlinesAfter; i++)
	{
		System.out.println();
	}
}

public void changeTo(String bin) {
	
	char[] ch = bin.toCharArray();
		
	int zeroIndex = (SIZE - 1) - ch.length;
	
	for(int i = 0; i < SIZE; i++)
	{
		if(i <= zeroIndex)
		{
			this.lw[i].set(0);
		}
		else if(i > zeroIndex)
		{
			if(ch[i - (zeroIndex + 1)] == '0')
			{
				this.lw[i].set(0);
			}
			else if(ch[i - (zeroIndex + 1)] == '1')
			{
				this.lw[i].set(1);
			}
		}
	}
}

public int[] parseAsInt(int startIndex, int endIndex) {
	
	int[] bits = new int[(endIndex - startIndex) + 1];
	
	for(int i = startIndex; i <= endIndex; i++)
	{
		bits[i - startIndex] = this.lw[i].getValue();
	}
	
	return bits;
}

public bit[] parseAsBit(int startIndex, int endIndex) {
	
	bit[] bits = new bit[(endIndex - startIndex) + 1];
	
	for(int i = 0; i < bits.length; i++)
	{
		bits[i] = new bit();
	}
	
	for(int i = startIndex; i <= endIndex; i++)
	{
		if(this.lw[i].getValue() == 0)
		{
			bits[i - startIndex].set(0);
		}
		if(this.lw[i].getValue() == 1)
		{
			bits[i - startIndex].set(1);
		}
	}
	
	return bits;
}

public String parseAsString(int startIndex, int endIndex) {
	
	String bits = "";
	
	for(int i = startIndex; i <= endIndex; i++)
	{
		if(this.lw[i].getValue() == 0)
		{
			bits += "0";
		}
		if(this.lw[i].getValue() == 1)
		{
			bits += "1";
		}
	}
	
	return bits;
}







}// end Class Longword
