package String_Matching;

import java.util.HashMap;
import java.util.Map;

public class Boyer_Moore {
    public int boyerMoore(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        int skip;
        int R = 26;
        int[] right = new int[R];
        for (char c = 'a'; c <= 'z'; c++) right[c % R] = -1;
        for (int j = 0; j < n; j++) right[needle.charAt(j) % R] = j;


        for (int i = 0; i <= h - n; i += skip){
            skip = 0;
            for (int j = n - 1; j >= 0; j--){
                if (needle.charAt(j) != haystack.charAt(i + j)){
                    skip = Math.max(1, j - right[haystack.charAt(i + j) % R]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }
}
