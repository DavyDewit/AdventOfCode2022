import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        List<String> input = Reader.readfile("Day3.txt");
        int score = 0;
        for (String line : input){
            String [] splittedLine = splitLines(line);
            char c = findEquals(splittedLine[0],splittedLine[1]);
            if(c != ' '){
                score += getCharValue(c);
            }
        }
        System.out.println("Score 1: "+score);
        score = 0;

        for(int i = 0; i < input.size(); i+=3){
            String [] lines = new String[3];
            for(int j = 0; j < 3; j++){
                lines[j] = input.get(i+j);
            }
            Arrays.sort(lines, Comparator.comparing(String::length).reversed());
            char c = findEquals(lines[0],lines[1],lines[2]);
            if(c != ' '){
                score += getCharValue(c);
            }
        }
        System.out.println("Score 2: "+score);
    }

    private static String[] splitLines(String line){
        int median = line.length()/2;
        String left = line.substring(0,median);
        String right = line.substring(median);
        return new String[]{left,right};
    }

    private static char findEquals(String left, String Right){
        for(int i = 0; i < left.length(); i++){
            char c = left.charAt(i);
            if(Right.contains(String.valueOf(c))){
                return c;
            }
        }
        return ' ';
    }

    private static char findEquals(String line1, String line2, String line3){
       for (int i = 0; i < line1.length(); i++){
           char c = line1.charAt(i);
              if(line2.contains(String.valueOf(c)) && line3.contains(String.valueOf(c))){
                return c;
           }
       }
       return ' ';
    }


    private static int getCharValue(char c){
        if(Character.isUpperCase(c))
            return (int)c - 38;
        else
            return (int)c - 96;
    }
}
