import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        PepTalk translator = new PepTalk(scanner.next());

        System.out.println(translator.getResult());

        scanner.close();

    }

}