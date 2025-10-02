package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Map;

/**
 * Writes symptom data to a plain text file
 * Each line of the file will contain a symptom and its occurrence count
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filepath;

    /**
     * Creates a new writer for the given file
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes the symptom data to the file
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (
                FileWriter fileWriter = new FileWriter(filepath);
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            writeLines(writer, symptoms);
        }
        catch (IOException e) {
            System.out.printf("File could not be written : %s", e.getMessage());
        }
    }

    /**
     * Writes each symptom entry to the file
     */
    private static void writeLines(BufferedWriter writer, Map<String, Integer> symptoms) throws IOException {
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        }
    }
}