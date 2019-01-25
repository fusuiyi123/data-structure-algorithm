package com.dsalglc.bit;

// Use ^ to remove even exactly same numbers and save the odd, or save the distinct bits and remove the same.
public class SumofTwoIntegers {
    public  static int getSum(int a, int b) {
        return b==0 ? a : getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }
}
