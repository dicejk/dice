package dice.cipher.test;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

import dice.cipher.NullCipher;

public class NullCipherTest
{

	
	@Test
	public void testProps()
	{
		Properties props = new Properties();
		NullCipher c = new NullCipher(props);
		String cipherText = c.encrypt("CUSTOMERS");
		System.out.println("CUSTOMERS" + cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("CUSTOMERS",plainText);
		assertTrue(cipherText.length() == plainText.length());
	}
	
	@Test
	public void testString()
	{
		NullCipher c = new NullCipher(null);
		String cipherText = c.encrypt("123456789");
		System.out.println(cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("123456789",plainText);
		assertTrue(cipherText.length() == plainText.length());
	}
	
	@Test
	public void testLong()
	{
		NullCipher c = new NullCipher(null);
		Long cipherText = c.encrypt(new Long(1234567891));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(1234567891),plainText);
	}
	
	
	
	

}
