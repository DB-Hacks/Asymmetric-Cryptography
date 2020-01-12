package asymmetric;

import java.math.BigInteger;

public class CRT {
	public static void main(String[] args) throws Exception
	{
		//c1 = x % n1
		//c2 = x % n2
		BigInteger n1 = new BigInteger("1055827021987");
		BigInteger n2 = new BigInteger("973491987203");
		BigInteger c1 = new BigInteger("365944767426");
		BigInteger c2 = new BigInteger("698856040412");

		BigInteger x = (((c1.multiply(n2).multiply(n2.modInverse(n1))).add(c2.multiply(n1).multiply(n1.modInverse(n2)))).mod((n1.multiply(n2))));
		System.out.println(x);
		System.out.println(x.mod(n1));
		System.out.println(x.mod(n2));
	}
}
