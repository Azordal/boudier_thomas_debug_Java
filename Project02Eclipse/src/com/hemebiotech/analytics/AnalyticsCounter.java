package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Handles the analytics of symptom data
 */
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Creates a new AnalyticsCounter with a given reader and writer
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Counts the occurrences of each symptom provided by the reader
     */
    public Map<String, Integer> countSymptoms() {
        Map<String, Integer> counts = new TreeMap<>();
        for (String symptom : getSymptoms()) {
            counts.put(symptom, counts.getOrDefault(symptom, 0) + 1);
        }
        return counts;
    }

    /**
     * Writes the symptom counts to the output using the writer
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    /**
     * Retrieves the list of symptoms from the reader
     */
    private List<String> getSymptoms() {
        return reader.getSymptoms();
    }
}