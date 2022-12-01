import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        List<String> input = getInput();
        System.out.println(GetBiggestKcal(input));
        List<Integer> sortedInput = SortInput(input);
        System.out.println(sortedInput.get(0) +sortedInput.get(1)+sortedInput.get(2));

    }

    private static List<String> getInput(){
        return Reader.readfile("Day1.txt");
    }

    private static List<Integer> SortInput(List<String> input){
        List<Integer> sortedInput = new ArrayList<>();
        int kcalGroup = 0;
        for (String line : input) {
            if(line.equals("")){
                sortedInput.add(kcalGroup);
                kcalGroup = 0;
            }else{
                kcalGroup += Integer.parseInt(line);
            }
        }
        sortedInput.add(kcalGroup);
        sortedInput.sort(Comparator.reverseOrder());
        return sortedInput;
    }

    private static int GetBiggestKcal(List<String> input){
        int biggestKcalGroup = 0;
        int kcalGroup = 0;
        for(String line : input){
            if(line.equals("")){
                if(kcalGroup > biggestKcalGroup){
                    biggestKcalGroup = kcalGroup;
                }
                kcalGroup = 0;
            }else{
                kcalGroup += Integer.parseInt(line);
            }
        }
        return biggestKcalGroup;
    }


}
