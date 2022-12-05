import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        List<String> input = Reader.readfile("Day5Crates.txt");
        CrateMover stackOrganiser = new CrateMover(createCrates(input));
        input = Reader.readfile("Day5Instructions.txt");
        List<Instruction> instructions = createInstructions(input);
        for (Instruction instruction:instructions) {
            //stackOrganiser.move9000(instruction);
            stackOrganiser.move9001(instruction);
        }
        stackOrganiser.PrintTop();
    }

    public static class Instruction{
        public int quanity;
        public int from;
        public int to;
        public Instruction(int quanity, int from, int to){
            this.quanity = quanity;
            this.from = from;
            this.to = to;
        }
    }
    public static class CrateMover{
        private List<Crate> stacks;
        public CrateMover(List<Crate> stacks){
            this.stacks = stacks;
        }
        public void move9000(Instruction instruction){
            Crate from = stacks.get(instruction.from-1);
            Crate to = stacks.get(instruction.to-1);
            int quanity = instruction.quanity;
            for(int i=0;i<quanity;i++){
                char crate = from.getTop();
                if(crate == ' '){
                    return;
                }
                to.add(crate);
            }
        }
        public void move9001(Instruction instruction){
            List<Character> crates = new ArrayList<>();
            Crate from = stacks.get(instruction.from-1);
            Crate to = stacks.get(instruction.to-1);
            int quanity = instruction.quanity;
            for(int i=0;i<quanity;i++){
                char crate = from.getTop();
                if(crate != ' '){
                    crates.add(crate);
                }
            }
            Collections.reverse(crates);
            for (char crate:crates) {
                to.add(crate);
            }
        }
        public void PrintTop(){
            for (Crate stack:stacks) {
                stack.printTop();
            }
        }
    }
    public static class Crate {
        private List<Character> stack;
        private char top;

        public Crate(char[] stack){
            this.stack = new ArrayList<>();
            for (char c : stack) {
                this.stack.add(c);
            }
            this.top = this.stack.get(this.stack.size() - 1);
        }

        public char getTop(){
            char OldTop = top;
            stack.remove(stack.size() - 1);
            if(stack.size() > 0){
                top = this.stack.get(this.stack.size() - 1);
            }else{
                top = ' ';
            }
            return OldTop;
        }

        public void add(char c){
            stack.add(c);
            top = c;
        }
        public void printTop(){
            System.out.print(top);
        }
    }

    private static List<Crate> createCrates(List<String> input){
        List<Crate> stacks = new ArrayList<>();
        for(String line : input){
            char[] stack = line.toCharArray();
            stacks.add(new Crate(stack));
        }
        return stacks;
    }

    private static List<Instruction> createInstructions(List<String> input){
        List<Instruction> instructions = new ArrayList<>();
        for(String line : input){
            line = line.replaceAll("[^0-9]+", " ");
            String[] numbers = line.trim().split(" ");
            int quanity = Integer.parseInt(numbers[0]);
            int from = Integer.parseInt(numbers[1]);
            int to = Integer.parseInt(numbers[2]);
            instructions.add(new Instruction(quanity, from, to));
        }
        return instructions;
    }
}
