package dice.cipher;

import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESCipher implements dice.cipher.Cipher
{

	public AESCipher(Properties props)
	{
		 SecretKeyFactory factory;
		try
		{
			factory = SecretKeyFactory.getInstance("AES");
			 SecretKeySpec spec = new SecretKeySpec(props.getProperty("aes_key").getBytes(), "AES");
		     this.key = factory.generateSecret(spec);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	public AESCipher(String password)
	{
		KeyGenerator kgen;
		try
		{
			kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			this.key = kgen.generateKey();
		}
		catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String encrypt(String clearText)
	{
		javax.crypto.Cipher cipher;
		try
		{
			cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] ivBytes = key.getEncoded();
			iv = new IvParameterSpec(ivBytes);
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key,iv);
			byte[] cipherText = cipher.doFinal(clearText.getBytes(("UTF-8")));
			return Base64.encodeBase64String(cipherText);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String decrypt(String cipherText)
	{
		javax.crypto.Cipher cipher;
		try
		{
			cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			//byte[] ivBytes = key.getEncoded();
			//IvParameterSpec iv = new IvParameterSpec(ivBytes);
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv);
			String plaintext = new String(cipher.doFinal(Base64.decodeBase64(cipherText)));
			return plaintext;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public byte[] encrypt2(String clearText)
	{
		
		/* Encrypt the message. */
		javax.crypto.Cipher cipher;
		try
		{
			cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
			byte[] ivBytes = key.getEncoded();
			iv = new IvParameterSpec(ivBytes);
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key,iv);
			byte[] ciphertext = cipher.doFinal(clearText.getBytes(("UTF-8")));
			return ciphertext;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[0];
	}

	
	public byte[] decrypt2(byte[] cipherText)
	{
		javax.crypto.Cipher cipher;
		try
		{
			cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
			byte[] ivBytes = key.getEncoded();
			IvParameterSpec iv = new IvParameterSpec(ivBytes);
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv);
			return cipher.doFinal(cipherText);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[0];
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
		return "AES";
	}
	
	private SecretKey key;
	private IvParameterSpec iv;
	@Override
	public boolean isMetaEncryptable()
	{
		return false;
	} 

}
