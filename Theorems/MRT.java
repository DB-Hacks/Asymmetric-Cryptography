package Theorems;

import java.math.BigInteger;

public class MRT {
	public static void main(String[] args) throws Exception
	{
		BigInteger n = new BigInteger("8191");
		BigInteger b = BigInteger.TWO;
		BigInteger e = n.subtract(BigInteger.ONE);
		boolean test = false;
		if(b.modPow(e, n).equals(BigInteger.ONE)) {
			System.out.println("composite");	//Test Case: composite
		}
		else {
			while(test == false) {
				if(e.mod(BigInteger.TWO) != BigInteger.ZERO) {
					System.out.println("Inconclusive");
					test = true;
				}
				e = e.divide(BigInteger.TWO);
				if(b.modPow(e, n) == n.subtract(BigInteger.ONE)) {
					System.out.println("Inconclusive");
					test = true;
				}
				else if(b.modPow(e, n) != BigInteger.ONE) {
					System.out.println("composite");
					test = true;
				}
			}
		}
	}
}
