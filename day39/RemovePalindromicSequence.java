package day39;

public class RemovePalindromicSequence {
    public int removePalindromeSub(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return 2;
        }
        return 1;
    }

    public static void main(String[] args) {
        RemovePalindromicSequence rps = new RemovePalindromicSequence();
        String s = "baabb";
        System.out.println(rps.removePalindromeSub(s));
    }
}
