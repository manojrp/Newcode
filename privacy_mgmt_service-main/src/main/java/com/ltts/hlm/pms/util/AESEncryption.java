package com.ltts.hlm.pms.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AESEncryption {

	private static final Logger LOG = LoggerFactory.getLogger(AESEncryption.class);
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String strToEncrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			LOG.error("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			LOG.error("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static void main(String[] args) {
		final String secretKey = "Ltts#$%HondaMarine_@2020!#@!";

		String originalString = "/home/azureuser/artifacts/USER_DP/";
		String encryptedString = AESEncryption.encrypt(originalString, secretKey);
		// String decryptedString = AESEncryption.decrypt(originalString, secretKey) ;
		LOG.info("Original string : " + originalString);
		LOG.info("Encrypted : " + encryptedString);
		// LOG.info("Decrypted : "+decryptedString);

	}
}