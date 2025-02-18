package day13;

public class Solution {
    public void moveZeroes(int[] nums) {

        if (nums.length == 0) return;
        int left = 0;
        for(int num : nums){
            if (num != 0){
                nums[left++] = num;
            }
        }
        while(left < nums.length){
            nums[left++] = 0;
        }
    }
} {
    
}
