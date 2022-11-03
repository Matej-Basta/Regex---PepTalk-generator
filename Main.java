import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        PepTalk translator = new PepTalk(scanner.next());

        translator.processingInput();

        scanner.close();

    }

}