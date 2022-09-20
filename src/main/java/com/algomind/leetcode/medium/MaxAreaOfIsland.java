package com.algomind.leetcode.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        Set<Point> visited = new HashSet<>();

        int maxIsland = 0;
        for(int y = 0 ; y < n; y ++) {
            for(int x = 0 ; x < m; x ++) {
                if(grid[y][x] == 0) continue;

                Set<Point> island = new HashSet<>();
                findIsland(new Point(x, y), island, grid, m, n, visited);
                maxIsland = Math.max(maxIsland, island.size());
            }
        }

        return maxIsland;
    }

    private void findIsland(Point p, Set<Point> island, int[][] grid, int m, int n, Set<Point> visited) {
        if(visited.contains(p)) return;
        visited.add(p);

        island.add(p);
        Set<Point> adjacent = getAdjacent(p, grid, m, n, visited);
        if(adjacent.size() == 0) return;

        for(Point adj : adjacent) {
            findIsland(adj, island, grid, m, n, visited);
        }
    }

    private Set<Point> getAdjacent(Point p, int[][] grid, int m, int n, Set<Point> visited) {
        Set<Point> adjacentPoints = new HashSet<>();
        if(p.x - 1 >= 0 && grid[p.y][p.x - 1] == 1) adjacentPoints.add(new Point(p.x - 1, p.y));
        if(p.y - 1 >= 0 && grid[p.y - 1][p.x] == 1) adjacentPoints.add(new Point(p.x, p.y - 1));
        if(p.x + 1 < m && grid[p.y][p.x + 1] == 1) adjacentPoints.add(new Point(p.x + 1, p.y));
        if(p.y + 1 < n && grid[p.y + 1][p.x] == 1) adjacentPoints.add(new Point(p.x, p.y + 1));
        adjacentPoints.removeAll(visited);
        return adjacentPoints;
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
