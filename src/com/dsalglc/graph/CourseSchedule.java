package com.dsalglc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
// topological sort
public class CourseSchedule {
    // 207. Course Schedule
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] edge: prerequisites) {
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int course = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            course++;
            if (map.containsKey(c)) {
                ArrayList<Integer> neighbors = map.get(c);
                for (int neighbor: neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return course == numCourses;
    }


    // 210. Course Schedule II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] edge: prerequisites) {
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            res[i++] = c;
            if (map.containsKey(c)) {
                ArrayList<Integer> neighbors = map.get(c);
                for (int neighbor: neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return i == numCourses ? res : new int[]{};
    }
}
