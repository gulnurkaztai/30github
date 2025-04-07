package day50;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetterOrDigit(ch[i])) {
                sb.append(ch[i]);
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
