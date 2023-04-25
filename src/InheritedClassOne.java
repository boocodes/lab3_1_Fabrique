import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InheritedClassOne implements ExternalInterface{
    public static String sliceText(String s, int posStart, int posEnd) { // убрать что то из текста
        return s.substring(posStart, posEnd);
    }
    public static long howManyTimesWordAtTheText(String text, String word) {
        long count =  Arrays
                .stream(text.split("\\s+"))
                .filter(word::equals)
                .count();
        return count;
    }
    public static String deleteWordFromText(String text, String word) {
        String buffText = text.replaceAll(word, "");
        return buffText;
    }

    public static ArrayList<String> fillWordsArray(String text) {
        ArrayList<String> wordsList = new ArrayList();
        int startPosition = 0;
        for(int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == ' ' || i == text.length() - 1) {
                String slicedWord = sliceText(text, startPosition, i + 1);
                startPosition = i + 1;
                wordsList.add(slicedWord.trim());
            }
        }
        return wordsList;
    }
    @Override
    public String deleteWords(String text) {
        ArrayList<String> wordsList = fillWordsArray(text);
        HashMap<String, Integer> buffWordAndCount = new HashMap<>();

        for(int i = 0; i < wordsList.size(); ++i) {
            buffWordAndCount.put(wordsList.get(i), (int)howManyTimesWordAtTheText(text, (String)wordsList.get(i)));
        }
        String buffText = text;

        for(Map.Entry entry : buffWordAndCount.entrySet()){
            if((int)entry.getValue() < 2){
                buffText = deleteWordFromText(buffText, (String)entry.getKey());
            }
        }
        return buffText;
    }
}
