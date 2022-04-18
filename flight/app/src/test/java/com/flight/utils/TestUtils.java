package com.flight.utils;
import com.flight.application.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {
    private static final String DB_SRC = "src/main/assets/db/flights.script";

    public static File copyDB() throws IOException {
        // FileOutputStream outputStream =new FileOutputStream(new File(newFilePath));
        Path target = Files.createTempFile("temp-db", ".script");
        target.toFile().deleteOnExit();
        // final File target = Files.createTempFile("temp-db", ".script").toFile();
        Files.copy(Paths.get(DB_SRC), target);
        Main.setDBPathName(target.toString().replace(".script", ""));
        return target.toFile();
    }
}
