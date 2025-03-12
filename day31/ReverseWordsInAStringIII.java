package day31;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            char[] chArr = word.toCharArray();
            int start = 0, end = chArr.length - 1;
            while (start < end) {
                char temp = chArr[end];
                chArr[end] = chArr[start];
                chArr[start] = temp;
                start++;
                end--;
            }
            res.append(new String(chArr)).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII rw = new ReverseWordsInAStringIII();
        String s = "Let's take LeetCode contest";
        String reversedstr = rw.reverseWords(s);
        System.out.print(reversedstr);
    }
}
