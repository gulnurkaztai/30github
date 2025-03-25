package day41;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];

        for (int i = 0; i < code.length; i++) {
            int sum = 0;

            if (k > 0) {

                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
            } else if (k < 0) {
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + code.length) % code.length];
                }
            }

            res[i] = sum;
        }

        return res;
    }
}
