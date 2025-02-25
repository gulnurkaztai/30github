package day21;

class Solution {
    public double myPow(double x, int n) {
        long exp = (long)n;
        if(exp < 0){
            exp = -exp;
            x = 1/x;
        }
        return my_pow(x, exp);
    }

    public double my_pow(double x, long exp) {
        if (exp == 0) return 1;
        return (exp%2 == 0)? my_pow(x*x, exp/2) : my_pow(x*x, exp/2)*x;
    }
}
