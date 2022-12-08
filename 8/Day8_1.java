import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8_1 {
    public static boolean isVisible(int row, int col, int[][] trees) {
        if (col == 0 || row == 0 || col == 98 || row == 98) {
            return true;
        }
        boolean up = true;
        boolean down = true;
        boolean right = true;
        boolean left = true;
        for (int i = 0; i < col; i++) {
            if (trees[row][i] >= trees[row][col]) {
                left =  false;
            }
        }
        for (int i = col+1; i < 99; i++) {
            if (trees[row][i] >= trees[row][col]) {
                right = false;
            }
        }
        for (int i = 0; i < row; i++) {
            if (trees[i][col] >= trees[row][col]) {
                up =  false;
            }
        }
        for (int i = row+1; i < 99; i++) {
            if (trees[i][col] >= trees[row][col]) {
                down = false;
            }
        }
        return up||down||right||left;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        int visibleTreesCount = 0;
        int[][] trees = new int[99][99];
        int i = 0;
        while ((line = input.readLine()) != null) {
            for (int j = 0; j < 99; j++) {
                trees[i][j] = Integer.valueOf(String.valueOf(line.toCharArray()[j]));
            }
            i++;
        }
        for (i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                visibleTreesCount += isVisible(i, j, trees) ? 1 : 0;
            }
        }
        System.out.println(visibleTreesCount);
        input.close();
    }
}
