package com.dsalglc.dfs;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    interface Robot {
        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }


    private int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // up right down left

    public void cleanRoom(Robot robot) {
        HashSet<String> set = new HashSet<>();
        int curDir = 0;
        backtrack(robot, set, 0, 0, 0);
    }

    public void backtrack(Robot robot, Set<String> set, int i, int j, int curDir) {
        String loc = i + "," + j;
        if (set.contains(loc)) return;
        robot.clean();
        set.add(loc);

        for (int k = 0; k < 4; k++) {
            if (robot.move()) {
                int x = i + dirs[curDir][0], y = j + dirs[curDir][1];
                backtrack(robot, set, x, y, curDir);

                // move back
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            curDir = (curDir + 1) % 4;
        }
    }
}
