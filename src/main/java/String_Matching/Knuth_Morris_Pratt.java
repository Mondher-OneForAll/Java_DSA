package String_Matching;

public class Knuth_Morris_Pratt {
    public int KMP(String haystack, String needle) {
        final int R = 26;
        int X, j, i;
        int n = needle.length();
        int h = haystack.length();

        int[][] dfa = new int[R][n];
        dfa[needle.charAt(0) % R][0] = 1;

        for (X = 0, j = 1; j < n; j++){

            for (char c = 'a'; c <= 'z'; c++)
                dfa[c % R][j] = dfa[c % R][X];

            dfa[needle.charAt(j) % R][j] = j + 1;
            X = dfa[needle.charAt(j) % R][X];

        }

        for (i = 0, j = 0; i < h && j < n; i++){
            j = dfa[haystack.charAt(i) % R][j];
        }
        if (j == n) return i - n;
        else return -1;
    }
}
