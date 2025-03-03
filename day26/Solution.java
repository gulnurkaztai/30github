package day26;

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(charArr[left])) {
                left++;
            } else if (!Character.isLetter(charArr[right])) {
                right--;
            } else {
                char temp = charArr[right];
                charArr[right] = charArr[left];
                charArr[left] = temp;
                left++;
                right--;
            }
        }
        return new String(charArr);
    }
}