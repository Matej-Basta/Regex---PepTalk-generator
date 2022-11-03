import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String finalResult = "";

        while (scanner.hasNext()) {
            PepTalk translator = new PepTalk(scanner.next());
            translator.processingInput();
            finalResult += translator.getResult() + " ";
        }

        System.out.println(finalResult);

        scanner.close();

    }

}