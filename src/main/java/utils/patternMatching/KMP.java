package utils.patternMatching;

public class KMP {
    public static int find(String text, String pattern) {
        char[] ctext = text.toCharArray();
        char[] cpattern = pattern.toCharArray();
        int n = text.length();
        int m = pattern.length();
        int respuesta = -1;
        int[] fail = computeFailKMP(pattern);
        int j = 0;
        int k = 0;
        while (j < n) {
            if (ctext[j] == cpattern[k]) {
                if (k == m - 1) {
                    respuesta = (j - m + 1);
                    k = 0;
                }
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else
                j++;
        }
        return respuesta;
    }

    private static int[] computeFailKMP(String pattern) {
        char[] cpattern = pattern.toCharArray();
        int m = cpattern.length;
        int[] fail = new int[m];
        int j = 1;
        int k = 0;
        while (j < m) {
            if (cpattern[j] == cpattern[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else
                j++;
        }
        return fail;
    }

}
