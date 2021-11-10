package package_Multiplier_ALU;
import package_RippleAdder.*;
import package_bit.*;
import package_longword.*;

public class Multiplier {

	public Multiplier() {}		//default constructor
	
	public static void main(String[] args) {
		
		
	}
	
	public static longword multiply(longword a, longword b) {
		
		/*
		 * Algorithm for A * B:
		 * 		
		 * 		sum = 0
		 * 		for each bit b[i] in B
		 * 				if b[i] == 0
		 * 					add 0 (or do nothing)
		 * 				if b[i] == 1
		 * 					sum += A.leftShift(i)
		 * 		return sum
		 */
		
		RippleAdder rp = new RippleAdder();
		longword sum = new longword();
		
		for(int i = (b.lw.length - 1); i >= 0; i--)			//a.lw.length == b.lw.length == 32 == SIZE
		{
			if(b.lw[i].getValue() == 0)
			{
				//do nothing - same as add 0
			}
			else	// b.lw[i].getValue() == 1
			{
				sum = rp.add(sum, a.leftShift(((b.lw.length - 1) - i)));		/* (((b.lw.length) - 1) - i) = the order-value 
				 																	of the current bit of B - since longwords are
				 																	represented from indices 0-SIZE, but their bit
				 																	order's are represented from SIZE-0 */
			}
		}
			
		return sum;
	}
	
}
