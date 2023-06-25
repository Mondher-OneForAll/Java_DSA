package String_Matching;

public class Brute_Force {
    public int bruteForce(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= h - n; i++){
            for (int j = 0; j < n; j++){
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                if (j == n - 1) return i;
            }

        }
        return -1;
    }
}
