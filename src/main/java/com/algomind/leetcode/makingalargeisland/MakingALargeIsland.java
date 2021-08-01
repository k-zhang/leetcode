package com.algomind.leetcode.makingalargeisland;

import java.util.HashSet;

public class MakingALargeIsland {
    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;
        int max = 1;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i ++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int index) {
            if(parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(rank[pa] <= rank [pb]) {
                parent[pa] = pb;
                rank[pb] += rank[pa];
                max = Math.max(max, rank[pb]);
            }else{
                parent[pb] = pa;
                rank[pa] += rank[pb];
                max = Math.max(max, rank[pa]);
            }
        }

        public int getRank(int a) {
            return rank[a];
        }

        public int getMax() {
            return max;
        }
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind unionFind = new UnionFind(n * m);

        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                if(grid[i][j] == 1) {
                    int index = i * n + j;
                    // Only scan the right and bottom of 1 element
                    if (i + 1 < m && grid[i + 1][j] == 1) unionFind.union(index, index + n);
                    if (j + 1 < n && grid[i][j + 1] == 1) unionFind.union(index, index + 1);
                }
            }
        }

        int originalMax = unionFind.getMax();

        int filledMax = 0;
        for(int i = 0 ; i < m ; i ++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    var rootSet = new HashSet<Integer>();
                    if(i - 1 >= 0 && grid[i - 1][j] == 1) rootSet.add(unionFind.find((i - 1) * n + j));
                    if(i + 1 < m && grid[i + 1][j] == 1) rootSet.add(unionFind.find((i + 1) * n + j));
                    if(j - 1 >= 0 && grid[i][j - 1] == 1) rootSet.add(unionFind.find(i * n + j - 1));
                    if(j + 1 < n && grid[i][j + 1] == 1) rootSet.add(unionFind.find(i * n + j + 1));

                    int localMax = 1;
                    for(var root : rootSet) {
                        localMax += unionFind.getRank(root);
                    }

                    filledMax = Math.max(filledMax, localMax);
                }
            }
        }

        return Math.max(originalMax, filledMax);
    }
}
