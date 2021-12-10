package utils.patternMatching;

public class BruteForce {

    public static int find(String texto, String patron) {
        int longitudTexto = texto.length();
        int longitudPatron = patron.length();

        for (int i = 0; i <= longitudTexto - longitudPatron; i++) { // Iterar sobre todo el texto
            int j = 0; // Iterar el patron
            while (j < longitudPatron && texto.charAt(i + j) == patron.charAt(j)) {
                j++;
            }
            if (j == longitudPatron) {
                return i;
                // return i;
            }
        }
        return -1;

    }

}
