import java.util.ArrayList;
import java.util.List;

public class Day4 {
    private static int overlapingSections = 0;
    public static class CleaningSection{
        public int start;
        public int end;
        public CleaningSection(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public Boolean IsOverlapping(CleaningSection other){
            if(this.start <= other.start && this.end >= other.start)
                return true;
            return this.start >= other.start && this.end <= other.end;
        }
        public boolean GetOverlapping(CleaningSection other){
            for(int i=other.start;i<=other.end;i++){
                if(IsInRange(i))
                    return true;
            }
            return false;
        }
        private boolean IsInRange(int value){
            return value >= this.start && value <= this.end;
        }
    }

    public static void main(String[] args) {
        List<String> input = Reader.readfile("Day4.txt");
        for (String line : input) {
            List<CleaningSection> section = mapInputToCleaningSections(line);
            if(section.get(0).GetOverlapping(section.get(1)))
                overlapingSections++;
        }
        System.out.println(overlapingSections);
    }
    private static List<CleaningSection> mapInputToCleaningSections(String input){
        List<CleaningSection> cleaningSections = new ArrayList<>();
        String[] lines = input.split(",");
        for (String line : lines){
            String[] splitLine = line.split("-");
            cleaningSections.add(new CleaningSection(Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1])));
        }
        return cleaningSections;
    }
}
