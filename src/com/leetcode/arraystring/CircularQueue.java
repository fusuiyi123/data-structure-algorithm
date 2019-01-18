package com.leetcode.arraystring;

public class CircularQueue {
    private final int[] array;
    private int front;
    private int rear;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        array = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % array.length;
            array[rear] = value;
            size++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % array.length;
            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : array[rear];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}
