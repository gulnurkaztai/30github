package day04;

import java.util.Arrays;

public class SingleNumber {

    public int singleNumber(int[] nums){

        Arrays.sort(nums);
        for (int i=0; i< nums.length-1; i +=2) {
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }

        return nums[nums.length-1];
        // int ans = 0;
        // for(int i=0; i< nums.length;i++){
        //     ans = ans^nums[i];
        // }
        // return ans;
    }

    public static void main(String[] args){
        SingleNumber sn = new SingleNumber();
        int[] nums = {1, 4, 3, 2, 3, 2,4};
        int res =sn.singleNumber(nums);
        System.out.println(res);
    }
}
