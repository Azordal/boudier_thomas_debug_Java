package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.List;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> symptoms = reader.getSymptoms();

        int headacheCount = 0;
        int rashCount = 0;
        int pupilCount = 0;

        for (String line : symptoms) {
            System.out.println("symptom from file: " + line);

            if (line.equals("headache")) {
                headacheCount++;
            } else if (line.equals("rash")) {
                rashCount++;
            } else if (line.contains("pupils")) {
                pupilCount++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dialated pupils: " + pupilCount + "\n");
        }

        System.out.println("Analysis complete. Results written to result.out");
    }
}