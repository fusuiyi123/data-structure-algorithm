package com.dsalglc.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

// 381. Insert Delete GetRandom O(1) - Duplicates allowed
public class RandomizedCollection {

    private ArrayList<Integer> nums;
    private HashMap<Integer, HashSet<Integer>> map;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            nums.add(val);
            HashSet<Integer> list = new HashSet<>();
            list.add(nums.size() - 1);
            map.put(val, list);
            return true;
        }
        nums.add(val);
        map.get(val).add(nums.size() - 1);
        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        HashSet<Integer> list = map.get(val);
        int loc = list.iterator().next();
        map.get(val).remove(loc);
        if (loc < nums.size() - 1) {
            int last = nums.size() - 1;
            int lastVal = nums.get(last);
            map.get(lastVal).remove(last);
            map.get(lastVal).add(loc);
            nums.set(loc, lastVal);
        }
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
