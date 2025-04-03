package day48;

import java.util.Arrays;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[][] freq = new int[51][2];
        // store the number in 2D array
        for (int i = 0; i < 51; i++)
            freq[i][0] = i;
        // count the frequency of the first k numbers
        for (int i = 0; i < k; i++)
            freq[nums[i]][1]++;
        res[0] = sum(freq, x);
        // sliding window
        for (int i = 1, j = k; j < n; i++, j++) {
            freq[nums[i - 1]][1]--;
            freq[nums[j]][1]++;
            res[i] = sum(freq, x);
        }
        return res;
    }

    int sum(int[][] freq, int x) {
        Arrays.sort(freq, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        int sum = 0;
        for (int i = 0; i < x; i++)
            sum += freq[i][0] * freq[i][1];
        Arrays.sort(freq, (a, b) -> a[0] - b[0]);
        return sum;
    }
}
