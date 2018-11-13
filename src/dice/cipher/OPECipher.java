package dice.cipher;

import java.math.BigInteger;
import java.util.Properties;

import jope.OPE;

public class OPECipher implements Cipher
{

	public OPECipher()
	{
		ope = new OPE();
	}
	
	public OPECipher(Properties props)
	{
		ope = new OPE();
	}
	
	@Override
	public String encrypt(String clearText)
	{
		// TODO Auto-generated method stub
		return clearText;
	}

	@Override
	public String decrypt(String cipherText)
	{
		// TODO Auto-generated method stub
		return cipherText;
	}

	@Override
	public Long encrypt(Long clearInt)
	{
		return ope.encrypt(BigInteger.valueOf(clearInt)).longValue();
	}

	@Override
	public Long decrypt(Long cipherInt)
	{
		return ope.decrypt(BigInteger.valueOf(cipherInt)).longValue();
	}

	@Override
	public String getName()
	{
		return "OPE Cipher";
	}
	
	private OPE ope;

	@Override
	public boolean isMetaEncryptable()
	{
		return false;
	}

}
