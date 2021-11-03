package ru.kpfu.itis.group001.kashapova.java_class.subsidiary;

import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangerUserDB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * генерация хеша через md5 + соль для любых подаваемых значений
 * (исп : password, token)
 */

public class MyHash {
    private static MessageDigest md;

    public static String createHashPassword(String password){
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangerUserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
