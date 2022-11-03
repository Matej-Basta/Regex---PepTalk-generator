import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class PepTalk {

    private String input;
    private String result;
    private List<String> dividedInput;
    
    public PepTalk(String input) {
        this.input = input;
        result = "";
        dividedInput = new ArrayList<>();
    }

    public String getResult() {
        return result;
    }

    public void processingInput() {
        Pattern patternForDivision = Pattern.compile("(.*?[aeiou][^aeiou]*)");
        Matcher matcher = patternForDivision.matcher(input);

        while (matcher.find()) {
            dividedInput.add(matcher.group(1));
        }

        for (String syllable : dividedInput) {
            System.out.println(syllable);
        }

    }



}