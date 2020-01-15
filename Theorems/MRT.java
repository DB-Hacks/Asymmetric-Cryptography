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
			System.out.println(n);
			System.out.println(b);
			System.out.println(e);
			System.out.println(b.modPow(e, n));
			System.out.println("composite 1");
		}
		else {
			while(test == false) {
				if(e.mod(BigInteger.TWO) != BigInteger.ZERO) {
					System.out.println("Inconclusive 1");
					test = true;
				}
				e = e.divide(BigInteger.TWO);
				if(b.modPow(e, n) == n.subtract(BigInteger.ONE)) {
					System.out.println("Inconclusive 2");
					test = true;
				}
				else if(b.modPow(e, n) != BigInteger.ONE) {
					System.out.println("composite 2");
					test = true;
				}
			}
		}
	}
}
