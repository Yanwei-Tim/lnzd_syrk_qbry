package com.founder.sydw.html2jpg;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {

	// 加密
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}
	
	// 加密
	public static String getBase64(byte[] byteArray) {
		String s = null;
		if (byteArray != null) {
			s = new BASE64Encoder().encode(byteArray);
		}
		return s;
	}

	// 解密
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(b != null){
				try {
					result = new String(b, "utf-8");
				} catch (Exception e) {
					result = new String(b);
				}
			}
		}
		return result;
	}

}
