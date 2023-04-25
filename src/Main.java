import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число класса: 1 - удалить не повторяющиеся слова, 2 - удалить повторяющиеся");
        int choice = Integer.parseInt(input.nextLine());
        System.out.println("Введите строку: ");
        String text = input.nextLine();
        TextOperationFactory factory = new TextOperationFactory();
        if (choice == 1) {
            ExternalInterface deleteSameWords = factory.getOperation(FunctionType.SAME);
            String response = deleteSameWords.deleteWords(text);
            System.out.println(response);
        } else if (choice == 2) {
            ExternalInterface deleteEqualWords = factory.getOperation(FunctionType.UNIQUE);
            String response = deleteEqualWords.deleteWords(text);
            System.out.println(response);
        } else {
            System.out.println("Такого варианта нет");
        }
    }
}