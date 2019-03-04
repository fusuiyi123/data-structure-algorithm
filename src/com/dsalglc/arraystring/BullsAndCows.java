package com.dsalglc.arraystring;

public class BullsAndCows {

    // 299. Bulls and Cows
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] number = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bull++;
            else {
                if (number[s] < 0) cow++;
                if (number[g] > 0) cow++;
                number[s]++;
                number[g]--;
            }
        }
        return bull + "A" + cow + "B";

    }
}
