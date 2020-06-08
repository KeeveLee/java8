package com.lk.极客时间.算法.数组链表;

import com.lk.utils.JsonUtil;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-20 18:42
 */
public class 岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '0', '1'}, {'1', '0', '1'}, {'1', '0', '1'}};
        System.out.println(JsonUtil.toString(grid));
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0) {
            return num;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    dfs(grid, r, c);
                }
            }
        }

        return num;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
