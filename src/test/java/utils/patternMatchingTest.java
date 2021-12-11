package utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import utils.patternMatching.BoyerMoore;
import utils.patternMatching.BruteForce;
import utils.patternMatching.KMP;

public class patternMatchingTest {
    private int testCases;
    private String[] texts;
    private String[] patterns;
    private int[] occurrences;

    @Before
    public void init() {
        texts = new String[] { "Esto es una prueba" };
        patterns = new String[] { "una" };
        occurrences = new int[] { 8 };
        testCases = texts.length;
    }

    @Test
    public void bruteForce() {
        int[] currentOccurrences = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            currentOccurrences[i] = BruteForce.find(texts[i], patterns[i]);
        }

        assertArrayEquals(currentOccurrences, occurrences);
    }

    @Test
    public void KMP() {
        int[] currentOccurrences = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            currentOccurrences[i] = KMP.find(texts[i], patterns[i]);
        }

        assertArrayEquals(currentOccurrences, occurrences);
    }

    @Test
    public void boyerMoore() {
        int[] currentOccurrences = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            currentOccurrences[i] = BoyerMoore.find(texts[i], patterns[i]);
        }

        assertArrayEquals(currentOccurrences, occurrences);
    }

}
