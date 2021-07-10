package com.algomind.contest.question2;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int ans = dfs(maze, dp, visited, entrance[1], entrance[0], entrance[1], entrance[0], m, n);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(char[][] maze, int[][] dp, boolean[][] visited, int sx, int sy, int x, int y, int m, int n) {
        if(x < 0 || x >= m || y < 0 || y >= n || visited[y][x] || maze[y][x] == '+') return Integer.MAX_VALUE;
        if(!(sx == x && sy == y) && (x == 0 || y == 0 || x == m - 1 || y == n - 1)) {
            return maze[y][x] == '.' ? 0 : Integer.MAX_VALUE;
        }

        if(dp[y][x] != 0) return dp[y][x];
        visited[y][x] = true;

        int ans = Integer.MAX_VALUE;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(var dir : directions) {
            int nextMove = dfs(maze, dp, visited, sx, sy, x + dir[1], y + dir[0], m, n);
            ans = nextMove == Integer.MAX_VALUE ? ans : Math.min(ans, nextMove + 1);
        }

        visited[y][x] = false;

        dp[y][x] = ans;

        return ans;
    }
}
