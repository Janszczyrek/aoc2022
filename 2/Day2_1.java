import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day2_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        int sum = 0;
        String line;
        while ((line = input.readLine()) != null) {
            if (line.contains("X")) {
                sum += 1;
                if (line.contains("A")) {
                    sum += 3;
                } else if (line.contains("C")) {
                    sum += 6;
                }
            }
            else if (line.contains("Y")) {
                sum += 2;
                if (line.contains("A")) {
                    sum += 6;
                } else if (line.contains("B")) {
                    sum += 3;
                }
            }
            else if (line.contains("Z")) {
                sum += 3;
                if (line.contains("B")) {
                    sum += 6;
                } else if (line.contains("C")) {
                    sum += 3;
                }
            }
        }
        input.close();
        System.out.println(sum);
    }
}