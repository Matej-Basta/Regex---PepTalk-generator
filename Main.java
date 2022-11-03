import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String word = scanner.next();

            Pattern pattern = Pattern.compile("[a,e,i,o,u]");
            String[] syllables = pattern.split(word);

            for (String syllable : syllables) {
                System.out.println(syllable);
            }
        }

        scanner.close();

    }

}