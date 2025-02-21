package day16;
class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotated = new int[nums.length];
        k = k % nums.length;
        for(int i = 0; i < nums.length; i++){
            rotated[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(rotated, 0, nums, 0, nums.length);
    }
}