package com.system.cafe.util;

import java.util.UUID;

public class UuidGenerator {
    public static String generateUuid() {
        UUID uuid = UUID.randomUUID();
        String base64 = uuid.toString().replaceAll("-", "");
        return base64.substring(0, 11);
    }
}
