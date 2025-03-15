package day33;

public class MergeStringsAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder newStr = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                newStr.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                newStr.append(word2.charAt(j));
                j++;
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately1768 ms = new MergeStringsAlternately1768();
        String word1 = "abc", word2 = "pqr";
        System.out.println(ms.mergeAlternately(word1, word2));
    }
}
