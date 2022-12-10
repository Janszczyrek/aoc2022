import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day10_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        int counter = 0;
        int register = 1;
        while ((line = input.readLine()) != null) {
            counter = draw(counter, register);
            counter++;
            if (line.contains("addx")) {
                counter = draw(counter, register);
                counter++;
                register += Integer.valueOf(line.split(" ")[1]);
            }
        }
        input.close();
    }

    static int draw(int counter, int register) {

        if (counter % 40 == 0) {
            counter = 0;
            System.out.println();
        }
        if (Math.abs(register - counter) < 2) {
            System.out.print("#");
        } else {
            System.out.print(".");
        }
        return counter;
    }
}
