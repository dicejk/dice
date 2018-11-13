package dice.cipher;

import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Properties;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.fpe4j.FF1;

public class FF1Cipher implements Cipher
{
	static byte[] encKey = { 64, -55, -20, -122, -32, -75, 19, 61, -64, -117,
			109, -118, 122, 125, 90, 114 };

	public FF1Cipher(int radix) {
		try
		{
			ff1 = new FF1(radix, 10);
			ff1_num = new FF1(10,10);
			KeyGenerator kgen;
			kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			this.key = kgen.generateKey();
			System.out.println();
			byte[] encoded = key.getEncoded();
			System.out.println(Arrays.toString(encoded));
			System.out.println();

		}
		catch (Exception e)
		{

		}
	}

	public FF1Cipher(Properties props) {
		try
		{
			ff1 = new FF1(255, 10);
			ff1_num = new FF1(10,10);
			this.key = new SecretKeySpec(encKey, "AES");

		}
		catch (Exception e)
		{

		}
	}

	@Override
	public String encrypt(String clearText)
	{
		return encrypt2(clearText, false);
	}

	private String encrypt2(String clearText, boolean isNum)
	{
		if(clearText.length() < 2)
		{
			return clearText;
		}
		char plainTextAsChar[] = clearText.toCharArray();
		int plainTextAsInt[] = new int[plainTextAsChar.length];
		for (int i = 0; i < plainTextAsChar.length; ++i)
		{
			plainTextAsInt[i] = plainTextAsChar[i] - (isNum ? '0' : ' ');
		}

		byte tweak[] = new byte[0];
		try
		{
			int[] resultInt = isNum ? ff1_num.encrypt(key, tweak,plainTextAsInt) : ff1.encrypt(key, tweak, plainTextAsInt);
			String result = new String();
			for (int i = 0; i < resultInt.length; ++i)
			{
				result += String.valueOf((char) resultInt[i]);
			}
			return result;
		}
		catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String();
	}

	@Override
	public String decrypt(String cipherText)
	{
		return decrypt2(cipherText, false);
	}

	private String decrypt2(String cipherText, boolean isNum)
	{
		if(cipherText.length() < 2)
		{
			return cipherText;
		}
		byte tweak[] = new byte[0];
		char cipherTextAsChar[] = cipherText.toCharArray();
		int cipherTextAsInt[] = new int[cipherTextAsChar.length];
		for (int i = 0; i < cipherTextAsChar.length; ++i)
		{
			cipherTextAsInt[i] = cipherTextAsChar[i];
		}
		try
		{
			int[] resultInt = isNum ? ff1_num.decrypt(this.key, tweak, cipherTextAsInt) : ff1.decrypt(this.key, tweak, cipherTextAsInt);
			System.out.println("decrypt:");
			String result = new String();
			for (int i = 0; i < resultInt.length; ++i)
			{
				result += String
						.valueOf((char) (resultInt[i] + (isNum ? '0' : ' ')));
			}
			return result;
		}
		catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String();
	}

	@Override
	public Long encrypt(Long clearInt)
	{
		return clearInt;
		/*clearInt *= 10;
		String encrypted = encrypt2(clearInt.toString(), true);
		String result = new String();
		for (int i = 0; i < encrypted.length(); ++i)
		{
			char c = (char) (encrypted.charAt(i) + '0');
			result += c;
		}
		return new Long(result);*/
	}

	@Override
	public Long decrypt(Long cipherInt)
	{
		return cipherInt;
		/*String cipherString = cipherInt.toString();
		String cipherStringLong = new String();
		for (int i = 0; i < cipherString.length(); ++i)
		{
			char c = (char) (cipherString.charAt(i) - '0');
			cipherStringLong += c;
		}

		String decrypted = decrypt2(cipherStringLong, true);
		return new Long(decrypted) / 10;*/
	}

	@Override
	public String getName()
	{
		return "FF1";
	}

	private org.fpe4j.FF1 ff1;
	private org.fpe4j.FF1 ff1_num;
	private SecretKey key;

	@Override
	public boolean isMetaEncryptable()
	{
		return false;
	}

}
