package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reads symptom data from a plain text file
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
    private final String filepath;

    /**
     * Creates a new reader for the file
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Reads all symptoms from the file
     */
    @Override
    public List<String> getSymptoms() {
        try (
                FileReader fileReader = new FileReader(filepath);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            return getLines(reader);
        }
        catch (IOException e) {
            System.out.printf("File could not be read : %s", e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Reads all lines from a buffered reader
     */
    private static List<String> getLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>();

        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        return lines;
    }
}