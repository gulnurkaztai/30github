package day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lastSeenSoFar = new HashMap<>();
        for (int i =0; i < nums.length; i++){
            int b = nums[i];
            int a = target - b;
            if (lastSeenSoFar.containsKey(a)){
                int res[] = new int[]{lastSeenSoFar.get(a), i};
                return res;
            }
            lastSeenSoFar.put(b,i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(nums, target);
        
        System.out.println(Arrays.toString(res));
    }
}


