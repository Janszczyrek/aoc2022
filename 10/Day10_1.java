import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day10_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        int counter = 0;
        int register = 1;
        List<Integer> signalStrength = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            counter++;
            if ((counter == 20) || (counter - 20) % 40 == 0) {
                signalStrength.add(counter * register);
            }
            if (line.contains("addx")) {
                counter++;
                if ((counter == 20) || (counter - 20) % 40 == 0) {
                    signalStrength.add(counter * register);
                }
                register += Integer.valueOf(line.split(" ")[1]);
            }
        }
        System.out.println(signalStrength.stream().reduce(0,Integer::sum));
        input.close();
    }
}
