package com.lk.极客时间.算法;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-13 18:37
 */
public class 八皇后 {
    int[] res = new int[8];

    public void cal8Queens(int row){
        if (row == 8){
            printQueen(res);
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (isOk(row, col)){
                res[row] = col;
                cal8Queens(row + 1);
            }
        }

    }

    private boolean isOk(int row, int col) {
        int leftUp = col - 1;
        int rightUp = col + 1;

        return false;
    }

    private void printQueen(int[] res) {
    }
}
