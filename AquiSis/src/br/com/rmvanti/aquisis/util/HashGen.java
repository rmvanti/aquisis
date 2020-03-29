package br.com.agricode.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author rmvanti
 */
public class HashGen {

    public static String genMD5(String value){
        return hash(value, "MD5");
    }
    
    public static String genSHA1(String value){
        return hash(value, "SHA-1");
    }
    
    public static String genSHA256(String value){
        return hash(value, "SHA-256");
    }
    
    public static String genSHA512(String value){
        return hash(value, "SHA-512");
    }
    
    private static String hash(String value, String algoritm){
        try {
            MessageDigest md = MessageDigest.getInstance(algoritm);
            byte[] hash =  md.digest(value.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02X", 0xff & b));
            }/* end for */
            return sb.toString();                                    
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("******************* Erro Geração de Hash *******************");
        }/* end catch */
        return null;      
    }
      

}/* end class */
