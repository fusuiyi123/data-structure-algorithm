package com.dsalglc.arraystring;

public class CountandSay {

    // 38. Count and Say
    // time: TODO
    public static String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i+1)) {
                i++;
                count++;
            }
            res.append(count).append(prev.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "," + countAndSay(i).length());
        }
//        String s = countAndSay(10);
//        System.out.println(s);
    }
}
