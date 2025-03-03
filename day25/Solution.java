package day25;

import java.util.Arrays;

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double minAverage = Double.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            double average = (nums[left] + nums[right]) / 2.0;
            if (average < minAverage) {
                minAverage = average;
            }
            left++;
            right--;
        }

        return minAverage;
    }
}
