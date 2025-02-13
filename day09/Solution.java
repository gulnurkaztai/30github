package day09;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        int ans = 0;

        for(int w: weights){
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right){
            int mid = (left + right)/2;
            int need =1;
            int curCap = 0;
            for(int w: weights){
                if(curCap + w > mid){
                    need +=1;
                    curCap = w;
                } else {
                    curCap +=w;
                }
            }
            if(need > days){
                left = mid+1;
            } else {
                ans = mid;
                right = mid -1;
            }
        }
  
    return ans;
    }
} {
    
}
