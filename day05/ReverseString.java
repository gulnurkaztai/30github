package day05;

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length -1;
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseString rs = new ReverseString();
        rs.reverseString(s);
        System.out.println(s);
        
    }
}
