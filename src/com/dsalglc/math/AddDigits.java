package com.dsalglc.math;

public class AddDigits {

    // Digital root
    // https://en.wikipedia.org/wiki/Digital_root
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
