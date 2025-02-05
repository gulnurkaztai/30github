class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowest_price = prices[0];

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - lowest_price);
            lowest_price = Math.min(lowest_price, prices[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {4, 5, 1, 6, 2};
        Solution solution = new Solution();
        int profit = solution.maxProfit(prices);
        System.out.println("Max profit: " + profit);
    }
}