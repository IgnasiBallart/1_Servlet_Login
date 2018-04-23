package com.MVCWithDAO.service.impl;

import java.security.MessageDigest;

public class MD5Hash {

    public static String hashString(String stringToHash) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(stringToHash.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
        }
    }

