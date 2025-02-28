package day24;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int ind = 0;
        for (int i = 0; i < g.length; i++) {
            while (ind < s.length && s[ind] < g[i]) {
                ind++;
            }
            if (ind == s.length) {
                break;
            }
            if (g[i] <= s[ind]) {
                count++;
                ind++;
            }
        }
        return count;
    }
}
