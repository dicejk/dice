package dice.cipher;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class StableGenericROT implements Cipher
{
	ArrayList<Character> alphabetNum = new ArrayList<Character>(
			Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
	ArrayList<Character> alphabetUpper = new ArrayList<Character>(Arrays.asList(
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
	ArrayList<Character> alphabetLower = new ArrayList<Character>(Arrays.asList(
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

	public StableGenericROT(int shift) {
		this.shift = shift;
	}

	public StableGenericROT(Properties props) {
		this.shift = new Integer(props.getProperty("dice_shift", "3"));
	}

	ArrayList<Character> getAlphabet(char c)
	{
		if (alphabetNum.indexOf(c) != -1)
		{
			return alphabetNum;
		}
		else if (alphabetUpper.indexOf(c) != -1)
		{
			return alphabetUpper;
		}
		else if (alphabetLower.indexOf(c) != -1)
		{
			return alphabetLower;
		}
		return new ArrayList<Character>();
	}

	public String encrypt(String clearText)
	{
		return encrypt(clearText, false);
	}

	public String encrypt(String clearText, boolean num)
	{
		StringBuffer cipherText = new StringBuffer();
		CharacterIterator it = new StringCharacterIterator(clearText);
		int overflow = 0;
		for (char c = it.last(); c != CharacterIterator.DONE; c = it.previous())
		{
			ArrayList<Character> alphabet = getAlphabet(c);
			int index = alphabet.indexOf(c);
			if (index != -1)
			{
				int newIndex = (index + shift + overflow + alphabet.size())
						% alphabet.size();
				if (index + shift + overflow >= alphabet.size())
				{
					overflow = 1;
				}
				else
				{
					overflow = 0;
				}
				cipherText.insert(0, alphabet.get(newIndex));
			}
			else
			{
				cipherText.insert(0, c);
			}
		}
		if (num && overflow == 1)
		{
			cipherText.insert(0, "1");
		}
		return cipherText.toString();
	}

	public String decrypt(String cipherText)
	{
		return decrypt(cipherText, false);
	}

	public String decrypt(String cipherText, boolean num)
	{
		StringBuffer clearText = new StringBuffer();
		if (cipherText != null)
		{
			CharacterIterator it = new StringCharacterIterator(cipherText);
			int overflow = 0;
			for (char c = it.last(); c != CharacterIterator.DONE; c = it
					.previous())
			{
				ArrayList<Character> alphabet = getAlphabet(c);
				int index = alphabet.indexOf(c);
				if (index != -1)
				{
					int newIndex = (index - shift - overflow + alphabet.size())
							% alphabet.size();

					clearText.insert(0, alphabet.get(newIndex));
					if (index - overflow - shift < 0)
					{
						overflow = 1;
					}
					else
					{
						overflow = 0;
					}
				}
				else
				{
					clearText.insert(0, c);
				}
			}
			if (num && overflow == 1)
			{
				clearText.delete(0, 1);
			}
		}
		return clearText.toString();
	}

	private final int shift;

	@Override
	public String getName()
	{
		return "StableGenericROT";
	}

	@Override
	public Long encrypt(Long clearInt)
	{
		String crypt = encrypt(clearInt.toString(), true);
		return new Long(crypt);
	}

	@Override
	public Long decrypt(Long cipherInt)
	{
		String cipher = cipherInt.toString();
		return new Long(decrypt(cipher, true));
	}

	@Override
	public boolean isMetaEncryptable()
	{
		return true;
	}
}
