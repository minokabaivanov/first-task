package com.ezgroceries.shoppinglist.util;

import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class TestHelperMethods {
    public static String resourceToString(String path) throws IOException {
        InputStream resourceAsStream = TestHelperMethods.class.getResourceAsStream(path);
        Assert.notNull(resourceAsStream, String.format("Resource '%s' not found", path));
        return new String(resourceAsStream.readAllBytes());
    }
}
