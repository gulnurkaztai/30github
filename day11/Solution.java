package day11;

class Solution {
    public int findKthNumber(int m, int n, int k) {
    int[] oneDArray = new int[m*n];
        int index = 0;
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++){                           
                oneDArray[index++] = i * j;
            } 
        }
        Arrays.sort(oneDArray);
    return oneDArray[k-1];
    }
}
