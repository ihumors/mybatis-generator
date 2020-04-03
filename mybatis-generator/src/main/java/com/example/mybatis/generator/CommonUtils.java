package com.example.mybatis.generator;

import java.util.Set;

public class CommonUtils {
    public static void splitByComma(String original, Set<String> result) {
        if (original == null) {
            return;
        }

        String[] splits = original.split(",");
        for (String split : splits) {
            String trimmed = split.trim();
            if (trimmed.length() > 0) {
                result.add(trimmed);
            }
        }

    }
}
