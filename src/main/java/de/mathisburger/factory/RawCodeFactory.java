package de.mathisburger.factory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RawCodeFactory {

    public static void WriteRawCode(String id, String body) throws IOException {
        File dest = new File("./" + id);
        if (dest.exists()) {
            dest.delete();
        }
        dest.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter("./" + id));
        writer.write(body);
        writer.close();
    }

    public static String readRawCode(String id) throws IOException {
        File dest = new File("./" + id);
        if (!dest.exists()) {
            return "";
        }
        return Files.readString(Paths.get("./" + id));
    }
}
