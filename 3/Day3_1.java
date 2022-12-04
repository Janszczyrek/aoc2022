import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day3_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        int sum = 0;
        String line;
        while ((line = input.readLine()) != null) {
            char[] rs1 = line.substring(0, (line.length()/2)).toCharArray();
            char[] rs2  = line.substring((line.length()/2)).toCharArray();
            HashMap<Integer,Character> rs2Map = new HashMap<>();
            for(int i = 0; i < rs2.length; i++) {
                rs2Map.put(i, rs2[i]);
            }
            for(int i = 0; i < rs1.length; i++) {
                if(rs2Map.containsValue(rs1[i])) {
                    sum += CharToValue(rs1[i]);
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    private static int CharToValue(Character a) {
        if((int)a < 97) return (int)a-38;
        else return (int)a-96;
    }
}