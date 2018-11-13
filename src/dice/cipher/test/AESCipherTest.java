package dice.cipher.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import dice.cipher.AESCipher;

public class AESCipherTest
{

	@Test
	public void testAES() throws UnsupportedEncodingException
	{
		for(int i = 0; i <100; i++)
		{
			AESCipher c = new AESCipher("");
			String cipherText = c.encrypt("123456789012345678");
			System.out.println(cipherText);
			String plainText = c.decrypt(cipherText);
			assertEquals("123456789012345678",new String(plainText));
		}
	}
	
	@Test
	public void testAESLength()
	{
		AESCipher c = new AESCipher("");
		String cipherText = c.encrypt("XYZTUUUUUU12345");
		String plainText = c.decrypt(cipherText);
		assertEquals("XYZTUUUUUU12345",plainText);
		assertFalse(cipherText.length() == plainText.length());
	}
	
}
