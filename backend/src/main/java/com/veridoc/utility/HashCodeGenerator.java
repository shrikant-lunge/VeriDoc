package com.veridoc.utility;

import java.security.MessageDigest;

public class HashCodeGenerator {

	public static String sha256(byte[] data) throws Exception
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashcode = digest.digest(data);
		
		StringBuffer sb = new StringBuffer();
		
		for(byte b: hashcode)
		{
			sb.append(String.format("%02x", b));
		}
		
		return sb.toString();
	}
}
