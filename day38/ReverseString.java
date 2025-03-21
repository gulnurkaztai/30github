package day38;

import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        ReverseString rs = new ReverseString();
        rs.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
