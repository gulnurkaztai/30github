package day40;

public class CountKConstraintSubstrings {
    public int countKConstraintSubstrings(String s, int k) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int zero = 0, one = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0')
                    zero++;
                if (s.charAt(j) == '1')
                    one++;
                if (zero <= k || one <= k)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountKConstraintSubstrings sub = new CountKConstraintSubstrings();
        String s = "10101";
        int k = 1;
        System.out.println(sub.countKConstraintSubstrings(s, k));
    }
}
