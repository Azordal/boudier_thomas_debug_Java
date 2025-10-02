package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    /**
     * Runs the symptom analytics process:
     * Reads input from "symptoms.txt"
     * Produces the output in "result.out"
     */
    public static void main(String[] args) {
        // Define input (symptoms.txt) and output (result.out)
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // Create the analytics processor
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Count the symptoms and write the results
        Map<String, Integer> counts = counter.countSymptoms();
        counter.writeSymptoms(counts);
    }
}
