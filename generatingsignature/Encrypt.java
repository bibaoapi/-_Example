package com.ergu.vctlh.generatingsignature;

import java.security.MessageDigest;

/** 
 * @author  LHK
 * @date 2016年12月2日 上午11:50:39 
 * @version 1.0 
 * @annotation 加密  
 */
public class Encrypt {
	/*
	 * MD5加密
	 */
	public static String md5(String s){
		try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16){
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
	}
	
	/*
	 * sha1加密
	 */
	public static String sha1(String s) {
		try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("SHA1");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
    		for(int i=0;i<md.length;i++){
    			int a = md[i];
    			if(a<0) a+=256;
    			if(a<16) sb.append("0");
    			sb.append(Integer.toHexString(a));
    		}
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
	}
}