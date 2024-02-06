package de.mathisburger.factory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Factory that helps to read/write code
 */
public class RawCodeFactory {

    /**
     * Write code to a simple file
     *
     * @param id The ID of the function
     * @param body The body that is written to the file
     * @throws IOException on bad file write
     */
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

    /**
     * Reads code from a simple file
     *
     * @param id The ID of the function
     * @throws IOException on bad file read
     */
    public static String readRawCode(String id) throws IOException {
        File dest = new File("./" + id);
        if (!dest.exists()) {
            return "";
        }
        return Files.readString(Paths.get("./" + id));
    }
}
