package Utility;

import java.security.MessageDigest;

/**
 * Created by Real on 2017-07-28.
 */
public class messageUtil {
    public static String keyGenerator(String message) throws Exception{
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] dataBytes = message.getBytes();
        byte[] dm = md.digest(dataBytes);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < dm.length; i++){
            sb.append(Integer.toString((dm[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
