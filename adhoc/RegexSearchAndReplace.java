import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearchAndReplace {
    private static String REGEX = "(?<=start)(.*)(?=end)";
    private static String INPUT = "asdsaddsada>startsdasd<risklevel>aggressive<end<adasd";
    private static String REPLACE = "<moderate>";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);

        System.out.println(INPUT);
    }
}