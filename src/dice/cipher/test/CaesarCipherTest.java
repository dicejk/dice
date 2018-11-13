package dice.cipher.test;

import static org.junit.Assert.*;
import org.junit.Test;

import dice.cipher.CaesarCipher;

public class CaesarCipherTest
{
	@Test
	public void testEncryptUpperString()
	{
		CaesarCipher c = new CaesarCipher(3);
		String cipherText = c.encrypt("TEST");
		assertEquals("WHVW", cipherText);
	}
	
	@Test
	public void testEncryptUpperString1_26()
	{
		for(int i = 1; i < 26; i++)
		{
			CaesarCipher c = new CaesarCipher(i);
			String plainText = new String("xyz");
			String plainText2 = new String("xya");
			String cipherText = c.encrypt(plainText);
			String cipherText2 = c.encrypt(plainText2);
			//System.out.println(cipherText + " : " + cipherText2);
			assertEquals(plainText, c.decrypt(cipherText));
			assertEquals(plainText2, c.decrypt(cipherText2));
			assertEquals(plainText2.compareTo(plainText) < 0,true);
			assertEquals(cipherText2.compareTo(cipherText) < 0,true);
		}
	}

	@Test
	public void testEncryptLowerString()
	{
		CaesarCipher c = new CaesarCipher(3);
		String cipherText = c.encrypt("xyz");
		assertEquals("\176\177\200", cipherText);
	}

	@Test
	public void testEncryptStringShift4()
	{
		CaesarCipher c = new CaesarCipher(2);
		String cipherText = c.encrypt("WXY");
		assertEquals("YZa", cipherText);
	}

	@Test
	public void testEncryptNonAlphabetSkip()
	{
		CaesarCipher c = new CaesarCipher(2);
		String cipherText = c.encrypt("WßX_Y");
		assertEquals("YßZ_a", cipherText);
	}

	@Test
	public void testDecryptString()
	{
		CaesarCipher c = new CaesarCipher(3);
		String clearText = c.decrypt("WHVW");
		assertEquals("TEST", clearText);
	}

	@Test
	public void testDecryptCircleString()
	{
		CaesarCipher c = new CaesarCipher(3);
		String clearText = c.decrypt("BCD");
		assertEquals("89A", clearText);
	}

	@Test
	public void testDecryptNull()
	{
		CaesarCipher c = new CaesarCipher(3);
		String cipherText = c.decrypt(new String());
		assertEquals("", cipherText);
	}
	
	@Test
	public void testDecryptEmpty()
	{
		CaesarCipher c = new CaesarCipher(3);
		String cipherText = c.decrypt("");
		assertEquals("", cipherText);
	}
	
	@Test
	public void testEncryptInt()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.encrypt(new Long(13));
		assertEquals(new Long(46), cipherText);
	}
	
	@Test
	public void testEncryptIntNegative()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.encrypt(new Long(-13));
		assertEquals(new Long(-46), cipherText);
	}
	
	@Test
	public void testEncryptIntOverflow()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.encrypt(new Long(13789));
		assertEquals(new Long(47122), cipherText);
	}
	
	@Test
	public void testEncryptIntOverflowMSB()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.encrypt(new Long(789));
		assertEquals(new Long(1122), cipherText);
	}
	
	@Test
	public void testEncryptIntOverflow768()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.encrypt(new Long(768));
		assertEquals(new Long(1101), cipherText);
	}
	
	@Test
	public void testIntDecrypt()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.decrypt(new Long(46));
		assertEquals(new Long(13), cipherText);
	}
	
	@Test
	public void testIntDecryptNegative()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.decrypt(new Long(-46));
		assertEquals(new Long(-13), cipherText);
	}
	
	@Test
	public void testIntDecryptOverflow()
	{
		CaesarCipher c = new CaesarCipher(3);
		//Long cipherText = c.decrypt(new Long(47122));
		assertEquals(new Long(13789),c.decrypt(c.encrypt(new Long(13789))));
		//assertEquals(new Long(13789), cipherText);
	}
	@Test
	public void testIntDecryptOverflowMSB()
	{
		CaesarCipher c = new CaesarCipher(3);
		Long cipherText = c.decrypt(new Long(4122));
		assertEquals(new Long(789), cipherText);
	}
	
	@Test
	public void testIntDecryptOverflow768()
	{
		CaesarCipher c = new CaesarCipher(3);
		assertEquals(new Long(768),c.decrypt(c.encrypt(new Long(768))));
		//Long cipherText = c.decrypt(new Long(4101));
		//assertEquals(new Long(768), cipherText);
	}
	
	@Test
	public void testEncryptInt8()
	{
		CaesarCipher c = new CaesarCipher(8);
		Long cipherText = c.encrypt(new Long(8));
		assertEquals(new Long(16), cipherText);
		Long plainText = c.decrypt(new Long(96));
		assertEquals(new Long(8),plainText);
	}
	
	@Test
	public void testEncryptIntLess9()
	{
		for(int j = -1000; j < 1000; j++)
		{
			for(int i = 1; i < 10; i++)
			{
				CaesarCipher c = new CaesarCipher(i);
				Long plainText = new Long(j);
				Long cipherText = c.encrypt(plainText);
				Long plainText2 = new Long(j+1);
				Long cipherText2 = c.encrypt(plainText2);
				assertEquals(plainText,c.decrypt(cipherText));
				assertTrue(plainText < plainText2);
				assertTrue(cipherText < cipherText2);
			}
		}
	}
	
	@Test
	public void testEncryptInt9()
	{
		for(int j = 0; j < 100; j++)
		{
			CaesarCipher c = new CaesarCipher(9);
			Long plainText = new Long(j);
			Long cipherText = c.encrypt(plainText);
			Long plainText2 = new Long(j+1);
			Long cipherText2 = c.encrypt(plainText2);
			assertEquals(plainText,c.decrypt(cipherText));
			assertTrue(plainText < plainText2);
			assertTrue(cipherText < cipherText2);
		}
	}
	@Test
	public void testStringCompare()
	{
		String a = "X";
		String b = "XA";
		String c = "Z";
		assertTrue(a.compareTo(b)< 0);
		assertTrue(b.compareTo(c)< 0);
	}
	
}
