import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        int sum = 0;
        ArrayList<Integer> max_sums = new ArrayList<>();
        while (input.ready()) {
            try {
                String line = input.readLine();
                sum += Integer.parseInt(line);
            } catch (NumberFormatException e) {
                if (max_sums.size() < 1) {
                    max_sums.add(sum);
                } else {
                    Collections.sort(max_sums);
                    if (max_sums.get(0) < sum) {
                        max_sums.set(0, sum);
                    }
                }
                sum = 0;
            }
        }
        input.close();
        System.out.println(max_sums.stream().reduce(0, Integer::sum));
    }
}