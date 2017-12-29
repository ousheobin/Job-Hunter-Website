package cn.gcu.utils;

public class VericodeUtil {
	
	public static String sendVerificationCode() {
		String verificationCode = ""+(int)((Math.random()*9+1)*100000);
		System.out.println(verificationCode);
		return verificationCode;
	}
	
}
