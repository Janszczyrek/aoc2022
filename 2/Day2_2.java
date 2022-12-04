import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day2_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        int sum = 0;
        String line;
        while ((line = input.readLine()) != null) {
            if (line.contains("A")) {
                if (line.contains("X")) {
                    sum += 3;
                } else if (line.contains("Y")) {
                    sum += 3;
                    sum += 1;
                } else if (line.contains("Z")) {
                    sum += 6;
                    sum += 2;
                }
            } else if (line.contains("B")) {
                if (line.contains("X")) {
                    sum += 1;
                } else if (line.contains("Y")) {
                    sum += 3;
                    sum += 2;
                } else if (line.contains("Z")) {
                    sum += 6;
                    sum += 3;
                }
            } else if (line.contains("C")) {
                if (line.contains("X")) {
                    sum += 2;
                } else if (line.contains("Y")) {
                    sum += 3;
                    sum += 3;
                } else if (line.contains("Z")) {
                    sum += 6;
                    sum += 1;
                }
            }
        }
        input.close();
        System.out.println(sum);
    }
}