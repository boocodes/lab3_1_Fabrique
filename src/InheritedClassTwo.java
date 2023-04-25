import java.util.Arrays;
import java.util.stream.Collectors;

public class InheritedClassTwo implements ExternalInterface{
    @Override
    public String deleteWords(String text){
        String result = Arrays.stream(text.split("\\s+")).distinct().collect(Collectors.joining(" "));
        return result;
    }
}
