package dice.cipher;

public interface Cipher
{
	public String encrypt(String clearText);
	public String decrypt(String cipherText);
	public Long encrypt(Long clearInt);
	public Long decrypt (Long cipherInt);
	public String getName();
	public boolean isMetaEncryptable();
}
