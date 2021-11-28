package com.codeworm47.atmsimulator.bankservice.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class ResourceReader {
    public static byte[] readBytes(String filePath) throws IOException {
        Resource resource = new ClassPathResource(filePath);
        return resource.getInputStream().readAllBytes();
    }

    public static String readRaw(String filePath) throws IOException {
        Resource resource = new ClassPathResource(filePath);
        byte[] bytes = readBytes(filePath);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
