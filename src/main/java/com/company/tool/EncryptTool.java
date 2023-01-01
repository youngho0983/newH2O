package com.company.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

@Component
public class EncryptTool {
    String encrpytKey = "tnmoasndfnldfnsal";

    public String encrypt(String data)   {
        String result = "";
        try {
            MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");
            messageDigest.update((data + encrpytKey).getBytes());
            byte[] pwdsalt = messageDigest.digest();

            StringBuilder sb = new StringBuilder();
            for(byte temp : pwdsalt) {
                sb.append(String.format("%02x",temp));
            }
            result = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

}
