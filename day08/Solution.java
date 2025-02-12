package day08;

class Solution {
    public int findMin(int[] nums) {
        int n =nums.length;
        if (n == 1 ) return nums[0];
        int min = nums[0];
        for(int i = 1; i < n; i++){
            if(min >= nums[i])
            min = nums[i];
        }
        return min;
    }

    //with binary search
    public int findMin2(int[] nums) {
        int n =nums.length;
        if (n == 1 ) return nums[0];
        if(nums[0] < nums[n-1]) return nums[0];
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = (start+ end)/2;
            if (mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[end]){
                start= mid +1;
            } 
            else end = mid -1;
        }
        return -1;
}
}
