package dice.cipher.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.cipher.GenericROT;
import dice.cipher.StableGenericROT;

public class GenericROTTest
{
	@Test
	public void testEncryptUpperString()
	{
		GenericROT c = new GenericROT(1);
		String cipherText = c.encrypt("XYZ");
		assertEquals("YZa", cipherText);
	}
	
	@Test
	public void testEncryptLowerString()
	{
		GenericROT c = new GenericROT(1);
		String cipherText = c.encrypt("xyz");
		assertEquals("yzz0", cipherText);
	}
	
	@Test
	public void testDecryptLowerString()
	{
		GenericROT c = new GenericROT(1);
		String cipherText = c.decrypt("yzz0");
		assertEquals("xyz", cipherText);
	}
	
	@Test
	public void testEncryptUpperString1_26()
	{
		for(int i = 1; i < 52; i++)
		{
			GenericROT c = new GenericROT(i);
			String plainText = new String("xyz");
			String plainText2 = new String("xya");
			String cipherText = c.encrypt(plainText);
			String cipherText2 = c.encrypt(plainText2);
			System.out.println(plainText + " : " + cipherText);
			assertEquals(plainText, c.decrypt(cipherText));
			assertEquals(plainText2, c.decrypt(cipherText2));
			assertEquals(plainText2.compareTo(plainText) < 0,true);
			assertEquals(cipherText2.compareTo(cipherText) < 0,true);
		}
	}
	
	@Test
	public void testStableGenericROTNumberTest()
	{
		StableGenericROT c = new StableGenericROT(3);
		String plainText = "149";
		String cipherText = c.encrypt(plainText);
		assertEquals("482",cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	
	@Test
	public void testStableGenericROTStringTest()
	{
		StableGenericROT c = new StableGenericROT(3);
		String plainText = "vwx";
		String cipherText = c.encrypt(plainText);
		assertEquals("zaa",cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	
	@Test
	public void testStableGenericROTMixedTest()
	{
		StableGenericROT c = new StableGenericROT(3);
		String plainText = "vw8x";
		String cipherText = c.encrypt(plainText);
		assertEquals("za2a",cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	
	@Test
	public void testStableGenericROTLongTest()
	{
		StableGenericROT c = new StableGenericROT(3);
		Long plainText = new Long(149);
		Long cipherText = c.encrypt(plainText);
		assertEquals(new Long(482),cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	
	@Test
	public void testStableGenericROTNegativeLongTest()
	{
		StableGenericROT c = new StableGenericROT(3);
		Long plainText = new Long(-149);
		Long cipherText = c.encrypt(plainText);
		assertEquals(new Long(-482),cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	
	@Test
	public void testStableGenericROTLeading0Test()
	{
		StableGenericROT c = new StableGenericROT(3);
		Long plainText = new Long(69);
		Long cipherText = c.encrypt(plainText);
		assertEquals(new Long(102),cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	
	@Test
	public void testStableGenericROTLeading767Test()
	{
		StableGenericROT c = new StableGenericROT(3);
		Long plainText = new Long(767);
		Long cipherText = c.encrypt(plainText);
		assertEquals(new Long(1100),cipherText);
		assertEquals(plainText,c.decrypt(cipherText));
	}
	

	

}
