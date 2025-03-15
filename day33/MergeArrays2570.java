package day33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeArrays2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                res.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res.add(nums1[i]);
                i++;
            } else { // (num1[i][0] > nums2[j][0])
                res.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            res.add(nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            res.add(nums2[j]);
            j++;
        }

        int[][] ans = new int[res.size()][];
        return res.toArray(ans);
    }

    public static void main(String[] args) {
        MergeArrays2570 ma = new MergeArrays2570();
        int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        int[][] res = ma.mergeArrays(nums1, nums2);

        for (int[] pair : res) {
            System.out.println(Arrays.toString(pair));
        }
    }
}