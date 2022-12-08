import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8_2 {
    public static int scenic(int row, int col, int[][] trees) {
        if (col == 0 || row == 0 || col == trees.length-1 || row == trees.length-1) {
            return 0;
        }
        int up = 0;
        int down = 0;
        int right = 0;
        int left = 0;
        for (int i = col-1; i >= 0; i--) {
            if ((trees[row][i] < trees[row][col])) {
                left++;
            }
            else {
                if ((trees[row][i] >= trees[row][col])) {
                    left++;
                }
                break;
            }
        }
        for (int i = col + 1; i < 99; i++) {
            if ((trees[row][i] < trees[row][col])) {
                right++;
            }
            else {
                if ((trees[row][i] >= trees[row][col])) {
                    right++;
                }
                break;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            if ((trees[i][col] < trees[row][col])) {
                up++;
            }
            else {
                if ((trees[i][col] >= trees[row][col])) {
                    up++;
                }
                break;
            }
        }
        for (int i = row + 1; i < 99; i++) {
            if ((trees[i][col] < trees[row][col])) {
                down++;
            }
            else {
                if ((trees[i][col] >= trees[row][col])) {
                    down++;
                }
                break;
            }
        }
        System.out.println(
                "x:" + row + " y:" + col + " up:" + up + " down:" + down + " left:" + left + " right:" + right + "total:"+up * down * left * right);
        return up * down * left * right;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        int maxScenic = 0;
        int[][] trees = new int[99][99];
        int i = 0;
        while ((line = input.readLine()) != null) {
            for (int j = 0; j < 99; j++) {
                trees[i][j] = Integer.valueOf(String.valueOf(line.toCharArray()[j]));
            }
            i++;
        }
        for (i = 0; i < 98; i++) {
            for (int j = 0; j < 99; j++) {
                maxScenic = scenic(i, j, trees) > maxScenic ? scenic(i, j, trees) : maxScenic;
            }
        }
        System.out.println(maxScenic);
        input.close();
    }
}
