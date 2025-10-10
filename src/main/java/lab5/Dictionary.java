package lab5;

import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private final List<String> words = Arrays.asList(
            "jab", "jabbed", "jabber", "jabbered", "jabbering", "jabbers", "jabberwocky", "jabbing", "jabot", "jabots",
            "jabs", "jacaranda", "jacarandas", "jacinth", "jack", "jackal", "jackals", "jackanapes", "jackanapeses", "jackass",
            "jackasses", "jackboot", "jackboots", "jackdaw", "jackdaws", "jacked", "jacket", "jacketed", "jacketing", "jackets",
            "jackhammer", "jackhammers", "jackie", "jacking", "jackknife", "jackpot", "jackpots", "jacks", "jackson", "jacksonville",
            "jaclyn", "jacob", "jacobean", "jacobian", "jacobin", "jacobins", "jacobite", "jacobites", "jacobs", "jacquard",
            "jacquards", "jacqueline", "jacques", "jactitation", "jactitations", "jactus", "jacuzzi", "jacuzzis", "jade", "jaded",
            "jadeite", "jadeites", "jades", "jading", "jaeger", "jaffa", "jag", "jagged", "jaggedly", "jaggedness",
            "jagger", "jags", "jaguar", "jaguars", "jai", "jail", "jailed", "jailer", "jailers", "jailhouse",
            "jailing", "jailor", "jailors", "jails", "jaipur", "jakarta", "jake", "jalopies", "jalopy", "jalousie",
            "jalousies", "jam", "jamaica", "jamaican", "jamaicans", "jamb", "jamboree", "jamborees", "jambs", "james",
            "jamey", "jamie", "jammed", "jamming", "jammy", "jams", "jan", "jane", "janeiro", "janet",
            "jangle", "jangled", "jangles", "jangling", "janice", "janitor", "janitorial", "janitors", "january", "januarys",
            "janus", "japan", "japanese", "japanned", "japanning", "japans", "jape", "japed", "japer", "japers",
            "japery", "japes", "japing", "japonica", "japonicas", "jar", "jardiniere", "jardinieres", "jarful", "jarfuls",
            "jargon", "jargons", "jarred", "jarring", "jarringly", "jarrow", "jars", "jasmine", "jasmines", "jason",
            "jasper", "jaspers", "jaundice", "jaundiced", "jaunt", "jaunted", "jauntier", "jauntiest", "jauntily", "jaunting",
            "jaunts", "jaunty", "java", "javanese", "javelin", "javelins", "jaw", "jawbone", "jawbones", "jawboning",
            "jawbreaker", "jawbreakers", "jawed", "jawing", "jaws", "jay", "jays", "jayvees", "jaywalk", "jaywalked",
            "jaywalker", "jaywalkers", "jaywalking", "jaywalks", "jazz", "jazzed", "jazzes", "jazzier", "jazziest", "jazzing",
            "jazzman", "jazzmen", "jazzy"
    );

    public List<String> getWords() {
        return words;
    }

    public String getWords(String command, int number, Wordable w) {
        // This will be implemented using the lambda expressions from Main
        return w.createString(command, number);
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int alphabeticalOrder(String a, String b) {
        return a.compareTo(b);
    }

    public static boolean isLengthAboveN(String s, int n) {
        return s.length() > n;
    }

    // 1. Static Nested Class
    public static class WordProperties {
        public static String getProperties(String word) {
            return String.format("Word: '%s', Length: %d, First Letter: %c",
                    word, word.length(), word.charAt(0));
        }
    }

    // 2. Inner Class
    public class WordSelector {
        public String selectFirstWordStartingWith(char letter) {
            for (String word : words) { // Accesses the outer class's 'words' list
                if (word.charAt(0) == letter) {
                    return word;
                }
            }
            return "No word found starting with '" + letter + "'.";
        }
    }

    public WordSelector getWordSelector() {
        return new WordSelector();
    }
}