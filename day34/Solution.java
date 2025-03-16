package day34;

class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (chars[i] != chars[j]) {
                chars[i] = chars[j] = (char) Math.min(chars[i], chars[j]);
            }
        }
        return new String(chars);
    }
}
