package com.dsalglc.others;

import java.util.Random;

public class ReservoirSampling {
    // the length of stream is very large
    static int[] selectKItems(int[] stream, int k) {
        assert stream.length >= k;
        int[] reservoir = new int[k];
        for (int i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }
        Random rand = new Random();
        for (int i = k; i < stream.length; i++) {
            int j = rand.nextInt(i + 1);
            if (j < k) reservoir[j] = stream[i];
        }
        return reservoir;
    }
}
