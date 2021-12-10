package utils.patternMatching;

public class BruteForce {

    public static int find(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) { // Iterar sobre todo el texto
            int j = 0; // Iterar el patron
            while (j < patternLength && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == patternLength) {
                return i;
            }
        }
        return -1;

    }

}
