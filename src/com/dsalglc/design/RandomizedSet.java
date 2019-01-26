package com.dsalglc.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            nums.add(val);
            map.put(val, nums.size() - 1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int loc = map.get(val);
            if (loc < nums.size() - 1) {
                int last = nums.get(nums.size() - 1);
                nums.set(loc, last);
                map.put(last, loc);
            }
            map.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
