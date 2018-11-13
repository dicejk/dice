package dice.cipher.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import dice.cipher.FF1Cipher;

public class FF1CipherTest
{

	@Test
	public void test()
	{
		FF1Cipher c = new FF1Cipher(255);
		String cipherText = c.encrypt("XYZTUUUUUU12345");
		System.out.println(cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("XYZTUUUUUU12345", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

	@Test
	public void testSciFi()
	{
		FF1Cipher c = new FF1Cipher(255);
		String cipherText = c.encrypt("Sci-Fi");
		System.out.println(cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("Sci-Fi", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

	@Test
	public void testProps()
	{
		Properties props = new Properties();
		FF1Cipher c = new FF1Cipher(props);
		String cipherText = c.encrypt("CUSTOMERS");
		System.out.println("CUSTOMERS" + cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("CUSTOMERS", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

	@Test
	public void testPropsAction()
	{
		Properties props = new Properties();
		FF1Cipher c = new FF1Cipher(props);
		String cipherText = c.encrypt("Action");
		System.out.println("Action:" + cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("Action", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}
	
	@Test
	public void testPropsAnimation()
	{
		Properties props = new Properties();
		FF1Cipher c = new FF1Cipher(props);
		String cipherText = c.encrypt("Animation");
		System.out.println("Animation:" + cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("Animation", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

	@Test
	public void testPropsODONNEL()
	{
		Properties props = new Properties();
		FF1Cipher c = new FF1Cipher(props);
		String cipherText = c.encrypt("PENELOPE O'DONNELL");
		System.out.println("PENELOPE O'DONNELL:" + cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("PENELOPE O'DONNELL", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

	@Test
	public void testDecryptODONNEL()
	{
		Properties props = new Properties();
		FF1Cipher c = new FF1Cipher(props);
		String plainText = c.decrypt("(Å&?Sy?ÀgÀhºgD;@÷p");
		assertEquals("PENELOPE O'DONNELL", plainText);
	}

	@Test
	public void testDecryptODONNELDatabase()
	{
		Connection targetConnection;
		String result = new String();
		try
		{
			Class.forName("dice.sql.DiceDriver");
			targetConnection = DriverManager.getConnection(
					"jdbc:dice:jdbc:mysql://192.168.110.128:3306/DICE_FF1",
					"dice", "dice");

			Statement stmt = targetConnection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select CATEGORYNAME from CATEGORIES where CATEGORY = 2");

			while (rs.next())
			{
				result = rs.getString(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		FF1Cipher c = new FF1Cipher(255);
		String plainText = c.decrypt(result);
		assertEquals("Animation", plainText);
	}

	@Test
	public void testNumbers()
	{
		FF1Cipher c = new FF1Cipher(255);
		String cipherText = c.encrypt("123456789");
		System.out.println(cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("123456789", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

	@Test
	public void testLong()
	{
		FF1Cipher c = new FF1Cipher(10);
		Long cipherText = c.encrypt(new Long(1234567891));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(1234567891), plainText);
	}

	@Test
	public void testLong1()
	{
		FF1Cipher c = new FF1Cipher(10);
		Long cipherText = c.encrypt(new Long(1));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(1), plainText);
	}

	@Test
	public void testLong2()
	{
		FF1Cipher c = new FF1Cipher(10);
		Long cipherText = c.encrypt(new Long(12));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(12), plainText);
	}

	@Test
	public void testLongLongProps()
	{
		FF1Cipher c = new FF1Cipher(null);
		Long cipherText = c.encrypt(new Long(12));
		System.out.println(cipherText);
		Long plainText = c.decrypt(cipherText);
		assertEquals(new Long(12), plainText);
	}

	@Test
	public void testString1()
	{
		FF1Cipher c = new FF1Cipher(255);
		String cipherText = c.encrypt("A");
		System.out.println(cipherText);
		String plainText = c.decrypt(cipherText);
		assertEquals("A", plainText);
		assertTrue(cipherText.length() == plainText.length());
	}

}
