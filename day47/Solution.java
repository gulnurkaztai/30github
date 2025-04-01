package day47;

class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (hm.containsKey(nums[i])) {

                int prev = hm.get(nums[i]);

                if (i - prev <= k) {
                    return true;
                }
            }

            hm.put(nums[i], i);
        }

        return false;
    }
}
