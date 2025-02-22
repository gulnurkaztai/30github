package day18;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length-2;i++){
            for(int j = 1; j < nums.length-1;j++){
                for(int k = 2; k < nums.length;k++){
                    if(i != j && i != k && j != k && nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            } 
        }  
        return new ArrayList<>(res);     
    }
}