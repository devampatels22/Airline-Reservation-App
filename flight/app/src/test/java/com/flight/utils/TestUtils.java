package com.flight.utils;
import com.flight.application.Main;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class TestUtils {
    private static final String DB_SRC = "src/main/assets/db/flights.script";

    public static File copyDB() throws IOException {
        final File target = File.createTempFile("temp-db", ".script");
        Files.copy(new File(DB_SRC), target);
        Main.setDBPathName(target.getAbsolutePath().replace(".script", ""));
        return target;
    }
}
