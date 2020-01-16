package RSA;

import java.math.BigInteger;

public class RSA {
	public static void main(String[] args) throws Exception
	{
		BigInteger phi = new BigInteger("8584037913642434144111279062847405921823163865842701785008602377400681495147541519557274092429073976252689387304835782258785521935078205581766754116919200");
		BigInteger q = new BigInteger("87020952829623092932322362936864583897972618059974315662422560067745889600571");
		BigInteger e = new BigInteger("65537");
		BigInteger p = phi.divide((q.subtract(BigInteger.ONE)));
		p = p.add(BigInteger.ONE);
		BigInteger n = p.multiply(q);
		BigInteger d = e.modInverse(phi);
		byte[] pt = "Super Secret Key".getBytes();
		BigInteger ptBig = new BigInteger(pt);

	    BigInteger c = ptBig.modPow(e,n);
	    
	    BigInteger bk = c.modPow(d,n);
	    System.out.println("BK = " + new String(bk.toByteArray()));		//Test Case: Super Secret Key
	}
}
