package package_RippleAdder;
import package_bit.*;
import package_longword.*;

public class RippleAdder {

	public RippleAdder() {}		//default constructor
	
	public static void main(String[] args) {

		
	}
	
	public static longword add(longword a, longword b) {
		
		final int SIZE = 32;					//longword max size
		bit c = new bit(0);						//carry-in bit, becomes the carry-out bit for the next addition in sequence
		bit sum[] = new bit[SIZE];				//hold sum of each bit for a + b
		int copy[] = new int[SIZE];				//will be the translated int array of sum[]
		
		longword xorLW = a.xor(b);								//xor'd longword of a and b
		longword andLW = a.and(b);								//and'd longword of a and b
		
		for(int i = (SIZE - 1); i >= 0 ; i--)
		{
			sum[i] = xorLW.lw[i].xor(c);						// S = X XOR Y XOR C-in
			c = andLW.lw[i].or((xorLW.lw[i].and(c)));			// C-out = X AND Y OR ((X XOR Y) AND C-in)
		}
		
		for(int i = 0; i < SIZE; i++)
		{
			copy[i] = sum[i].getValue();
		}
		
		longword l = new longword(copy);
		
		return l;
	}
	
	public static longword subtract(longword a, longword b) {
		
		final int SIZE = 32;					//longword max size
		bit c = new bit(0);						//borrow bit (B-in)
		bit dif[] = new bit[SIZE];				//hold difference of each bit for a + b
		int copy[] = new int[SIZE];				//will be the translated int array of dif[]
		
		longword xorLW = a.xor(b);								//xor'd longword of a and b
		longword notA = a.not();								//not'd (negation) longword of a
		
		for(int i = (SIZE - 1); i >= 0; i--)
		{
			dif[i] = xorLW.lw[i].xor(c);												//Dif = X XOR Y XOR B-in
			c = notA.lw[i].and(c).or(notA.lw[i].and(b.lw[i]).or(b.lw[i].and(c)));		//B-out = NOT-A AND B-in OR NOT-A AND B OR B AND B-in
		}
		
		for(int i = 0; i < SIZE; i++)
		{
			copy[i] = dif[i].getValue();
		}
		
		longword l = new longword(copy);
		
		return l;
	}

}
