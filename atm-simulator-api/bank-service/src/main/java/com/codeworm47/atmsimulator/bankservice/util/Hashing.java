package com.codeworm47.atmsimulator.bankservice.util;

import org.apache.commons.codec.digest.DigestUtils;

public final class Hashing {
    public static String sha256Hex(String value){
        return DigestUtils.sha256Hex(value);
    }
}
