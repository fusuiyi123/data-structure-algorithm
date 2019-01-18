package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Design {


    // 146. LRU Cache, double linked list and hashmap
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        HashMap<Integer, Node> map;
        Node head;
        Node tail;
        int capacity;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = null;
            tail = null;
            this.capacity = capacity;
        }

        private void remove(Node node) {
            if (node.pre != null) {
                node.pre.next = node.next;
            } else {
                head = node.next;
            }

            if (node.next != null) {
                node.next.pre = node.pre;
            } else {
                tail = node.pre;
            }
        }

        private void setHead(Node node) {
            node.next = head;
            node.pre = null;
            if (head != null) {
                head.pre = node;
            }
            head = node;
            if (tail == null) {
                tail = head;
            }
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                setHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                setHead(node);
                map.put(key, node);
            } else {
                if (map.size() >= capacity) {
                    map.remove(tail.key);
                    remove(tail);
                }
                Node node = new Node(key, value);
                setHead(node);
                map.put(key, node);
            }
        }
    }



    // 251 Flatten 2D Vector
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
