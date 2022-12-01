import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Reader {
    public static List<String> readfile(String filename)
    {
        Path path = Path.of(System.getProperty("user.home"));
        path = path.resolve("Documents/AdventOfCode2022/ReaderFiles/"+filename);
        try{
            return Files.readAllLines(path);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}