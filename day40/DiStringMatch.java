package day40;

import java.util.Arrays;

public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        char[] ch = s.toCharArray();
        int start = 0, end = n;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'I') {
                perm[i] = start++;
            } else {
                perm[i] = end--;
            }
        }
        perm[n] = start;
        return perm;
    }

    public static void main(String[] args) {
        DiStringMatch dsm = new DiStringMatch();
        String s = "IDID";
        System.out.println(Arrays.toString(dsm.diStringMatch(s)));
    }
}
