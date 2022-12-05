import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.lang.Character;

public class Day5_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input"));
        String line;
        StackList stacks = new StackList();
        while ((line = input.readLine()) != null) {
            if(line.contains("move")) {
                int count = Integer.valueOf(line.split(" ")[1]);
                int from = Integer.valueOf(line.split(" ")[3]);
                int to = Integer.valueOf(line.split(" ")[5]);
                for(int i = 0; i < count; i++) {
                    stacks.stacklist.get(to-1).push(stacks.stacklist.get(from-1).pop());
                }
            }
        }
        input.close();
        System.out.println(stacks.topElements());
    }

}

class StackList {
    public ArrayList<Stack<Character>> stacklist;
    StackList(){
        stacklist = new ArrayList<>();
        populate();
    }
    private void populate() {
        for(int i = 0;i < stack_data.length; i++)
        {
            stacklist.add(new Stack<Character>());
            for(char c : stack_data[i].toCharArray()) {
               stacklist.get(i).push(Character.valueOf(c));
        }

        }
    }
    public String topElements() {
        String res = "";
        for(Stack<Character> s : stacklist) {
            res += s.peek();
        }
        return res;
    }
    private String[] stack_data = {"WRF","THMCDVWP","PMZNL","JCHR","CPGHQTB","GCWLFZ","WVLQZJGC","PNRFWTVC","JWHGRSV"};
}