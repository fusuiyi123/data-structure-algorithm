package com.dsalglc.design;

import java.util.Iterator;
import java.util.List;

// Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
// iterator.next(); // return 1
// iterator.next(); // return 2
// iterator.next(); // return 3
// iterator.hasNext(); // return true
// iterator.hasNext(); // return true
// iterator.next(); // return 4
// iterator.hasNext(); // return false
public class Flatten2DVector {

    // 251. Flatten 2D Vector
    public class Vector2D implements Iterator<Integer> {

        private Iterator<List<Integer>> i;
        private Iterator<Integer> j;
        public Vector2D(List<List<Integer>> vec2d) {
            i = vec2d.iterator();
        }

        @Override
        public Integer next() {
            hasNext();
            return j.next();
        }

        @Override
        public boolean hasNext() {
            while ((j == null || !j.hasNext()) && i.hasNext()) {
                j = i.next().iterator();
            }
            return j != null && j.hasNext();
        }
    }
}
