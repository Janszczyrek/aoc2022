import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day6_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        while ((line = input.readLine()) != null) {
            for(int i = 3; i < line.length(); i++) {
                if(isStrUnique(line.substring(i-3, i+1))) {
                    System.out.println(++i);
                    break;
                }
            }
        }
        input.close();
    }

    public static Boolean isStrUnique(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i - 1] == chars[i]) {
                return false;
            }
        }
        return true;
    }
}
