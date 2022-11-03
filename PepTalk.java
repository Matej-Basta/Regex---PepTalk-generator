import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class PepTalk {

    private String input;
    private String result;
    private List<String> dividedInput;
    private List<String> correctlyDividedInput;
    
    public PepTalk(String input) {
        this.input = input;
        result = "";
        dividedInput = new ArrayList<>();
        correctlyDividedInput = new ArrayList<>();
    }

    public String getResult() {
        return result;
    }

    public void processingInput() {
        Pattern patternForDivision = Pattern.compile("((.*?)[aeiou][^aeiou]*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = patternForDivision.matcher(input);

        while (matcher.find()) {
            dividedInput.add(matcher.group(1));
        }

        String removedElements = "";

        for (int i = 0; i <dividedInput.size(); i++) {
            String syllable = dividedInput.get(i);
            String[] syllableChars = syllable.split("");
            List<String> listOfChars = new ArrayList<>();
            for (String character : syllableChars) {
                listOfChars.add(character);
            }

            int numberToBeReplaced = 0;
            if (i != 0) {
                numberToBeReplaced = (listOfChars.size() - 1) % 2 == 0 ? (listOfChars.size() - 1) / 2 : ((listOfChars.size() - 1) / 2) + 1;
            } else {
                Matcher matcher3 = patternForDivision.matcher(syllable);
                while (matcher3.find()) {
                    int prefix = matcher3.group(2).length();
                    numberToBeReplaced = (listOfChars.size() - 1 - prefix) % 2 == 0 ? (listOfChars.size() - 1 - prefix) / 2 : ((listOfChars.size() - 1 - prefix) / 2) + 1;
                }
                
            }

            if (!removedElements.equals("")) {
                listOfChars.add(0,removedElements);
                removedElements="";
            }
            
            if (i != dividedInput.size() - 1) {
                
                for (int j = 1; j < numberToBeReplaced + 1; j++) {
                    String removedElement = listOfChars.remove(listOfChars.size()-1);
                    removedElements = removedElement + removedElements;
                }
            }

            String newSyllable = "";
            for (String character : listOfChars) {
                newSyllable += character;
            }

            correctlyDividedInput.add(newSyllable);
        }

        Pattern patternForReplacingConsonants = Pattern.compile("[^aeiou]*", Pattern.CASE_INSENSITIVE);

        for (String syllable : correctlyDividedInput) {
            Matcher matcher2 = patternForReplacingConsonants.matcher(syllable);
            result += syllable;
            String adjustedSyllable = matcher2.replaceFirst("p").toLowerCase();
            result += adjustedSyllable;
        }

    }



}