package com.hemebiotech.analytics;

import java.util.List;
/**
 * Interface for classes that read symptom data from a source
 */
public interface ISymptomReader {
    List<String> getSymptoms();
}