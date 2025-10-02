package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new TreeMap<>();
        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }
        return symptomCount;
    }

    public void writeSymptoms(Map<String, Integer> symptomCount) {
        writer.writeSymptoms(symptomCount);
    }

    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> counts = counter.countSymptoms(symptoms);
        counter.writeSymptoms(counts);
    }
}