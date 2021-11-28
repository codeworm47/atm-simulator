package com.codeworm47.atmsimulator.bankservice.utils;

import org.apache.commons.codec.binary.Base64;

public final class CodecUtils {
    public static String toBase64URI(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        sb.append("data:image/png;base64,");
        sb.append(org.apache.commons.codec.binary.StringUtils.newStringUtf8(Base64.encodeBase64(bytes, false)));
        return sb.toString();
    }
}
