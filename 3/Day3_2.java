import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day3_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        HashMap<Character,Integer> rsMap = new HashMap<>();
        HashMap<Character,Integer> occuredInLine = new HashMap<>();
        int sum = 0;
        int lineNum = 0;
        String line;
        while ((line = input.readLine()) != null) {
            for(Character c : line.toCharArray()) {
                if(!occuredInLine.containsKey(c)) {
                    rsMap.merge(c, 1, Integer::sum);
                    occuredInLine.put(c,1);
                }
            }
            occuredInLine.clear(); 
            if (++lineNum%3==0) {
                sum += CharToValue(rsMap.entrySet().stream().max((e1,e2)->e1.getValue()>e2.getValue()?1:-1).get().getKey());
                rsMap.clear();
            }
        }
        System.out.println(sum);
    }
    private static int CharToValue(Character a) {
        if((int)a < 97) return (int)a-38;
        else return (int)a-96;
    }
}