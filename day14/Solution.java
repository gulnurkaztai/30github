package day14;

class Solution {
    public int compress(char[] chars) {
        int streakStart = 0;
        int ansIndex = 0;
        while (streakStart < chars.length){
            char streakChar = chars[streakStart];
            int end = streakStart;
            int count =1;
            while(end +1 < chars.length && chars[end+1] == streakChar){
                end++;
                count++;
            }
            chars[ansIndex] = streakChar;
            ansIndex++;
            if(count > 1){
                char[] countAsChars = Integer.toString(count).toCharArray();
                for(char digit : countAsChars){
                    chars[ansIndex] = digit;
                    ansIndex++;
                }
            }
            streakStart = end +1;
        }
        return ansIndex;
    }
}
