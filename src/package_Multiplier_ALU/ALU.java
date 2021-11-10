package package_Multiplier_ALU;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class ALU {

	/* Members */
	
	public static RippleAdder rp;		//ripple adder
	public static Multiplier m;		//multiplier
	
	/* Constructors */
	
	public ALU() {			//default constructor
		rp = new RippleAdder();
		m = new Multiplier();
	}		
	
	public static void main(String[] args) {

		longword a = new longword(8);
		longword b = new longword(3);
		
		a.printBinary(0,1);
		b.printBinary(0,2);
		
		bit bitobj = new bit();
		bit[] arr = bitobj.strToBitArr("1000");
		bit[] arr2 = bitobj.strToBitArr("0111");
		
		
		System.out.println(doOp(arr2, a, b));

		
	}

	public static longword doOp(bit[] operation, longword a, longword b) {
				
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 0)
			{
				if(operation[2].getValue() == 0)
				{
					if(operation[3].getValue() == 0)
					{
						// do and()
						longword result = a.and(b);
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 0)
			{
				if(operation[2].getValue() == 0)
				{
					if(operation[3].getValue() == 1)
					{
						// do or()
						longword result = a.or(b);
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 0)
			{
				if(operation[2].getValue() == 1)
				{
					if(operation[3].getValue() == 0)
					{
						// do xor()
						longword result = a.xor(b);
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 0)
			{
				if(operation[2].getValue() == 1)
				{
					if(operation[3].getValue() == 1)
					{
						// do not() - ignore longword b
						longword result = a.not();
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 1)
			{
				if(operation[2].getValue() == 0)
				{
					if(operation[3].getValue() == 0)
					{
						// do leftShift() - left shift longword a by amount: value of longword b
						longword result = a.leftShift(b.getSigned());
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 1)
			{
				if(operation[2].getValue() == 0)
				{
					if(operation[3].getValue() == 1)
					{
						// do rightShift() - right shift longword a by amount: value of longword b
						longword result = a.rightShift(b.getSigned());
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 1)
			{
				if(operation[2].getValue() == 1)
				{
					if(operation[3].getValue() == 0)
					{
						// do add()
						longword result = rp.add(a, b);
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 1)
		{
			if(operation[1].getValue() == 1)
			{
				if(operation[2].getValue() == 1)
				{
					if(operation[3].getValue() == 1)
					{
						// do subtract()
						longword result = rp.subtract(a, b);
						return result;
					}
				}
			}
		}
		
		if(operation[0].getValue() == 0)
		{
			if(operation[1].getValue() == 1)
			{
				if(operation[2].getValue() == 1)
				{
					if(operation[3].getValue() == 1)
					{
						// do multiply()
						longword result = m.multiply(a, b);
						return result;
					}
				}
			}
		}
		
		return null;

	}
	
//	public static longword doOp(bit[] operation, longword a) {
//		
//		if(operation[0].getValue() == 1)
//		{
//			if(operation[1].getValue() == 0)
//			{
//				if(operation[2].getValue() == 1)
//				{
//					if(operation[3].getValue() == 1)
//					{
//						// do not()
//						longword result = a.not();
//						return result;
//					}
//				}
//			}
//		}
//
//		return null;
//	}
//	
//	public static longword doOp(bit[] operation, longword a, int amount) {
//		
//		if(operation[0].getValue() == 1)
//		{
//			if(operation[1].getValue() == 1)
//			{
//				if(operation[2].getValue() == 0)
//				{
//					if(operation[3].getValue() == 0)
//					{
//						// do leftShift()
//						longword result = a.leftShift(amount);
//						return result;
//					}
//				}
//			}
//		}
//		
//		if(operation[0].getValue() == 1)
//		{
//			if(operation[1].getValue() == 1)
//			{
//				if(operation[2].getValue() == 0)
//				{
//					if(operation[3].getValue() == 1)
//					{
//						// do rightShift()
//						longword result = a.rightShift(amount);
//						return result;
//					}
//				}
//			}
//		}
//		
//		return null;
//	}
	
	

	
	/* Helper Methods */
	
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

	
}		//end Class ALU
