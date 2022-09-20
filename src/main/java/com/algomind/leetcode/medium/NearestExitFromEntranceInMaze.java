package com.algomind.leetcode.medium;

import java.util.LinkedList;

public class NearestExitFromEntranceInMaze {
    private final int MAX = (int)10e5;

    // Failed 1 test case out of 192
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int ans = dfs(maze, dp, visited, entrance[1], entrance[0], entrance[1], entrance[0], m, n);

        return ans == MAX? -1 : ans;
    }

    private int dfs(char[][] maze, int[][] dp, boolean[][] visited, int sx, int sy, int x, int y, int m, int n) {
        if(x < 0 || x >= m || y < 0 || y >= n || visited[y][x] || maze[y][x] == '+') return MAX;
        if((!(sx == x && sy == y)) && (x == 0 || y == 0 || x == m - 1 || y == n - 1)) {
            return maze[y][x] == '.' ? 0 : MAX;
        }

        if(dp[y][x] != 0) return dp[y][x];
        visited[y][x] = true;

        int ans = MAX;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(var dir : directions) {
            int nextMove = dfs(maze, dp, visited, sx, sy, x + dir[1], y + dir[0], m, n);
            ans = Math.min(ans, nextMove + 1);
        }

        visited[y][x] = false;

        dp[y][x] = ans;

        return ans;
    }

    // My Answer
    public int nearestExit2(char[][] maze, int[] entrance) {
        var n = maze.length;
        var m = maze[0].length;

        var dp = new int[n][m];
        var directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        var queue = new LinkedList<int[]>();
        queue.push(entrance);

        while(!queue.isEmpty()) {
            var current = queue.poll();

            var x = current[1];
            var y = current[0];

            if((x == 0 || x == m - 1 || y == 0 || y == n - 1) && !(x == entrance[1] && y == entrance[0])) {
                return dp[y][x];
            }

            for(var dir : directions) {
                var px = x + dir[1];
                var py = y + dir[0];

                if(px < 0 || py < 0 || px >= m || py >= n) continue;

                if(maze[py][px] == '.' && dp[py][px] == 0) {
                    dp[py][px] = dp[y][x] + 1;
                    queue.add(new int[]{py,px});
                }
            }
        }

        return -1;
    }
}
