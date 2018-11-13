package dice.cipher;

import java.util.Properties;

public class NullCipher implements Cipher
{

	public NullCipher(Properties props) {

	}

	@Override
	public String encrypt(String clearText)
	{
		return clearText;
	}

	@Override
	public String decrypt(String cipherText)
	{
		return cipherText;
	}

	@Override
	public Long encrypt(Long clearInt)
	{
		return clearInt;
	}

	@Override
	public Long decrypt(Long cipherInt)
	{
		return cipherInt;
	}

	@Override
	public String getName()
	{
		return "Null Cipher";
	}

	@Override
	public boolean isMetaEncryptable()
	{
		return true;
	}

}
