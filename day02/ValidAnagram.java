package day02;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int freq[] = new int[26];
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        for (int i = 0; i < sarr.length; i++){
            char x = sarr[i];
            freq[x - 'a']++;
        }
        for (int i = 0; i < tarr.length; i++){
            char x = tarr[i];
            freq[x - 'a']--;
        }

        for (int i = 0; i < freq.length; i++){
            if (freq[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "anagram";
        String t = "garamna";
        ValidAnagram va = new ValidAnagram();
        boolean res = va.isAnagram(s,t);

        System.out.println(res);
    }
}
