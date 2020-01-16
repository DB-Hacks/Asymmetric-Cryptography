package RSA;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public class RSA_ECB_NoPadding {
	public static void main(String[] args) throws Exception
	{
		BigInteger phi = new BigInteger("8584037913642434144111279062847405921823163865842701785008602377400681495147541519557274092429073976252689387304835782258785521935078205581766754116919200");
		BigInteger q = new BigInteger("87020952829623092932322362936864583897972618059974315662422560067745889600571");
		BigInteger e = new BigInteger("65537");
		BigInteger p = phi.divide((q.subtract(BigInteger.ONE)));
		p = p.add(BigInteger.ONE);
		BigInteger n = p.multiply(q);
		BigInteger d = e.modInverse(phi);
		byte[] pt = "Tomorrows meeting has been postponed.".getBytes();
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(n, e);
		RSAPrivateKeySpec privSpec = new RSAPrivateKeySpec(n, d);
		PublicKey pub = keyFactory.generatePublic(pubSpec);
		PrivateKey priv = keyFactory.generatePrivate(privSpec);
		Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, pub);
		byte[] ct = cipher.doFinal(pt);
		
		cipher.init(Cipher.DECRYPT_MODE, priv);
		byte[] bk = cipher.doFinal(ct);
		System.out.println(new String(bk));		//Test Case: Tomorrows meeting has been postponed.
	}
}
