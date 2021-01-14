package utils.impl;

import utils.Generator;

public class UserIdGenerator implements Generator {
    private static int UNIQUE_ID = 0;

    public static int getUniqueId() {
        return ++UNIQUE_ID;
    }
}
