package Theorems;

import java.math.BigInteger;

public class CRT {
	public static void main(String[] args) throws Exception
	{
		//Property 1: c1 = x % n1
		//Property 2: c2 = x % n2
		BigInteger n1 = new BigInteger("1055827021987");
		BigInteger n2 = new BigInteger("973491987203");
		BigInteger c1 = new BigInteger("365944767426");
		BigInteger c2 = new BigInteger("698856040412");

		BigInteger x = (((c1.multiply(n2).multiply(n2.modInverse(n1))).add(c2.multiply(n1).multiply(n1.modInverse(n2)))).mod((n1.multiply(n2))));
		
		//The smallest integer x that satisfies the two properties 
		System.out.println(x);
	}
}
