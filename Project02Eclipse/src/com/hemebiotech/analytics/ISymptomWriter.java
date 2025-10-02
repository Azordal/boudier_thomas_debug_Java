package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for classes that write symptom data to a destination
 */
public interface ISymptomWriter {
    void writeSymptoms(Map<String, Integer> symptoms);
}
