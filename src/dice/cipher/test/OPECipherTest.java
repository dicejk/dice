package dice.cipher.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.cipher.OPECipher;

public class OPECipherTest
{
	
	@Test
	public void testLong0()
	{
		OPECipher c = new OPECipher();
		Long cipherText = c.encrypt(new Long(0));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(0),plainText);
	}
	
	@Test
	public void testLong()
	{
		OPECipher c = new OPECipher();
		Long cipherText = c.encrypt(new Long(1234567891));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(1234567891),plainText);
	}
	
	@Test
	public void testLong56()
	{
		OPECipher c = new OPECipher();
		Long cipherText = c.encrypt(new Long(56));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(56),plainText);
	}
	
	@Test
	public void testLongMinus()
	{
		OPECipher c = new OPECipher();
		Long cipherText = c.encrypt(new Long(-100));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(-100),plainText);
	}
	@Test
	public void testString()
	{
		OPECipher c = new OPECipher();
		String cipherText = c.encrypt("Test");
		assertEquals("Test",cipherText); // no encryption
		
		String plainText = c.decrypt(cipherText);
		assertEquals("Test",plainText);
	}
	
	
	
	

}


