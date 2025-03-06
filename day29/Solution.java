package day29;

public class Solution {
    public int removePalindromeSub(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return 2;
            }
        }
        return 1;
    }
}
