package day27;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int temp1 = 0;
        int temp2 =0 ;

        while(temp1<word1.length()||temp2<word2.length())
        {
            if(temp1<word1.length())
            {
                res = res + word1.charAt(temp1);
                temp1++;
            }
             if(temp2<word2.length())
            {
                res = res + word2.charAt(temp2);
                temp2++;
            }
        }
            return res;
        
    }
}{

}
