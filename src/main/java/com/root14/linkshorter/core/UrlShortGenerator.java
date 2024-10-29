package com.root14.linkshorter.core;

import java.util.UUID;

public class UrlShortGenerator {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public String generate() {
        stringBuilder.delete(0, stringBuilder.length());

        String result = UUID.randomUUID().toString();
        result = result.substring(0, 8);
        stringBuilder.append(result);

        return stringBuilder.toString();
    }
}
