package dice.cipher;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class CaesarCipherNoMeta implements Cipher
{
	ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('0',
			'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '\176', '\177', '\200',
			'\201', '\202', '\203', '\204', '\205', '\206', '\207', '\210',
			'\211', '\212', '\213', '\214', '\215', '\216', '\217', '\220',
			'\221', '\222', '\223', '\224', '\225', '\226', '\227'));

	public CaesarCipherNoMeta(int shift) {
		this.shift = shift;
	}

	public CaesarCipherNoMeta(Properties props) {
		this.shift = new Integer(props.getProperty("dice_shift", "3"));
	}

	public String encrypt(String clearText)
	{
		StringBuffer cipherText = new StringBuffer();
		CharacterIterator it = new StringCharacterIterator(clearText);
		for (char c = it.first(); c != CharacterIterator.DONE; c = it.next())
		{
			int index = alphabet.indexOf(c);
			if (index != -1)
			{
				int newIndex = (index + shift) % alphabet.size();
				cipherText.append(alphabet.get(newIndex));
			}
			else
			{
				cipherText.append(c);
			}
		}
		return cipherText.toString();
	}

	public String decrypt(String cipherText)
	{
		StringBuffer clearText = new StringBuffer();
		if (cipherText != null)
		{
			CharacterIterator it = new StringCharacterIterator(cipherText);
			for (char c = it.first(); c != CharacterIterator.DONE; c = it
					.next())
			{
				int index = alphabet.indexOf(c);
				if (index != -1)
				{
					int newIndex = (index - shift + alphabet.size())
							% alphabet.size();
					clearText.append(alphabet.get(newIndex));
				}
				else
				{
					clearText.append(c);
				}
			}
		}
		return clearText.toString();
	}

	private final int shift;

	@Override
	public String getName()
	{
		return "Caesar's Cipher";
	}

	@Override
	public Long encrypt(Long clearInt)
	{
		Long result = new Long(0);
		int sign = clearInt >= 0 ? 1 : -1;
		int count = 0;
		String clearText = clearInt.toString();
		for (int i = clearText.length(); i > 0; --i)
		{
			if (clearText.charAt(i - 1) != '-')
			{
				int n = Character.digit(clearText.charAt(i - 1), 10);
				result = result + ((n + shift) * (int) Math.pow(10, count++));
			}
		}
		return result * sign;
	}

	@Override
	public Long decrypt(Long cipherInt)
	{
		Long result = Math.abs(cipherInt);
		int sign = cipherInt >= 0 ? 1 : -1;
		int count = 0;
		String clearText = cipherInt.toString();
		for (int i = clearText.length(); i > 0; --i)
		{
			if (clearText.charAt(i - 1) != '-')
			{
				int step = (shift * (int) Math.pow(10, count++));
				if (step <= result)
					result = result - step;
			}
		}
		return result * sign;
	}

	@Override
	public boolean isMetaEncryptable()
	{
		return false;
	}
}
