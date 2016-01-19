package org.pb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {
	
	private static String m_token = "weixinbkserver";
	
	public static boolean check(String signature, String timestamp, String nonce)
	{
		// 1. sort token, timestamp and nonce
		String arr[] = new String[]{m_token, timestamp, nonce};
		Arrays.sort(arr);
		
		// 2. combine three string and sha1
		StringBuilder buffer = new StringBuilder();
		for (int i=0; i<arr.length; ++i)
		{
			buffer.append(arr[i]);
		}
		
		MessageDigest md = null;
		String temp_str = null;
		try{
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(buffer.toString().getBytes());
			temp_str = byte_to_str(digest);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		buffer = null;
		
		return temp_str != null ? temp_str.equals(signature.toUpperCase()) : false;
	}
	
	// 
	private static String byte_to_str(byte[] byte_arr)
	{
		String digest_str = "";
		for (int i=0; i<byte_arr.length; ++i)
		{
			digest_str += byte_to_hex(byte_arr[i]);
		}
		return digest_str;
	}
	
	private static String byte_to_hex(byte b)
	{
		char[] ox_arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] temp_arr = new char[2];
		temp_arr[0] = ox_arr[(b >>> 4) & 0x0f];
		temp_arr[1] = ox_arr[b & 0x0f];
		
		String s = new String(temp_arr);
		return s;
	}
}
