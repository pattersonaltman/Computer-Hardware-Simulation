package package_bit;

public class bit implements IBit{
	
	private int value;
	
	/* Constructors */
	
	public bit() {}		//default constructor
	
	public bit(int value) {
		this.value = value;
	}
	
	public static void main(String[] args) {



	}
	
	/* Methods */

	public void set(int value) {
		
		if(value == 0)
		{
			this.value = value;			//set value if 0
		}
		else if(value == 1)
		{
			this.value = value;			//set value if 1
		}
		else							//otherwise don't set, print error message
		{
			System.out.println("\nError: valid set-values are either 0 or 1\nBit value not set\n");
		}
	}
	
	public void toggle() {
		if(this.value == 0)
		{
			this.value = 1;				//toggle 0 to 1
		}
		else if(this.value == 1)
		{
			this.value = 0;				//toggle 1 to 0
		}
	}
	
	public void set() {				//set bit to 1
		this.value = 1;
	}
	
	public void clear() {			//set bit to 0
		this.value = 0;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public bit and(bit other) {					//both bits must pass
		bit b = new bit();
		
		if(this.value == 0)						//both bits must be 1 - primary bit fails
		{
			b.set(0);
		}
		
		if(this.value == 1)
		{
			if(other.getValue() == 0)				//primary bit passes, secondary bit fails
			{
				b.set(0);
			}
			else if(other.getValue() == 1)			//primary bit passes, secondary bit passes
			{
				b.set(1);
			}
		}
		
		return b;
	}
	
	public bit or(bit other) {						//at least one bit must pass
		bit b = new bit();
		
		if(this.value == 0)
		{
			if(other.getValue() == 0)				//primary bit fails, secondary bit fails
			{
				b.set(0);
			}
			else if(other.getValue() == 1)			//primary bit fails, secondary bit passes
			{
				b.set(1);
			}
		}
		
		if(this.value == 1)						//primary bit passes
		{
			b.set(1);
		}
		
		return b;
	}
	
	public bit xor(bit other) {						//1 bit must pass, 1 must fail (differ)
		bit b = new bit();
		
		if(this.value == 0)
		{
			if(other.getValue() == 0)				//primary & secondary are same
			{
				b.set(0);
			}
			else if(other.getValue() == 1)			//primary & secondary differ
			{
				b.set(1);
			}
		}
		
		if(this.value == 1)
		{
			if(other.getValue() == 0)				//primary & secondary differ
			{
				b.set(1);
			}
			else if(other.getValue() == 1)			//primary and secondary are same
			{
				b.set(0);
			}
		}
		
		return b;
	}
	
	public bit not() {					//set new bit to the opposite value
		bit b = new bit();
		
		if(this.value == 0)
		{
			b.set(1);
		}
		
		if(this.value == 1)
		{
			b.set(0);
		}
		
		return b;
	}
	
	public String toString() {
		return this.value + "";		//turns the return result into a String
	}
	
	
	
	/*
	 * Additional methods:
	 * 
	 * The following are additional methods, not part of the assignment, added to make future testing
	 * more convenient.
	 * 
	 * Method Description list:
	 * 		- bit[] strToBitArr(String bits) - 
	 */
	

	public static bit[] strToBitArr(String bits) {
		
		final int size = 4;		// Will only account for the first 4 bits taken from a String
		bit[] arr = new bit[size];
		for(int i = 0; i < size; i++)
		{
			arr[i] = new bit();
		}
		
		for(int i = 0; i < size; i++)
		{
			if(bits.charAt(i) == '0')
			{
				arr[i].set(0);
			}
			else if(bits.charAt(i) == '1')
			{
				arr[i].set(1);
			}
		}
		return arr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
