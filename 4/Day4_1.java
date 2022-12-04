import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        int sum = 0;
        while ((line = input.readLine()) != null) {
            Range r1 = new Range(
                    Integer.valueOf(line.split(",")[0].split("-")[0]),
                    Integer.valueOf(line.split(",")[0].split("-")[1]));
            Range r2 = new Range(
                    Integer.valueOf(line.split(",")[1].split("-")[0]),
                    Integer.valueOf(line.split(",")[1].split("-")[1]));
            if (r1.Contains(r2) || r2.Contains(r1)) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}

class Range {
    int min;
    int max;

    Range(int n, int x) {
        this.min = n;
        this.max = x;
    }

    public Boolean Contains(Range other) {
        if ((this.min <= other.min) && (this.max >= other.max))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.min + "..." + this.max;
    }
}