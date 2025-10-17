package lab5;
import java.util.List;

/**
 * 满足实验 Part 2 要求的 Dictionary 类。
 * 单词列表使用 static final 定义，效率最高且全局唯一。
 * 同时，为了满足 Part 5 的部分要求，此类包含了静态嵌套类和内部类。
 */
public class Dictionary {

    private static final List<String> WORDS = List.of(
            "jab", "jabbed", "jabber", /* ...所有单词... */ "jazzman", "jazzmen", "jazzy"
    );

    // Part 2: 必须包含的 getWords 方法 (正确的实现)
    public String getWords(String command, int number, Wordable w) {
        StringBuilder sb = new StringBuilder();
        for (String word : WORDS) {
            sb.append(w.createString(word, number));
        }
        return sb.toString();
    }

    // 提供一个获取单词列表的方法，方便 Main 类使用
    public List<String> getWordList() {
        return WORDS;
    }

    // Part 2: 要求的三个静态辅助方法
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int alphabeticalOrder(String a, String b) {
        return a.compareTo(b);
    }

    public static boolean isLengthAboveN(String s, int n) {
        return s.length() > n;
    }

    // --- Part 5: Nested Classes Demo ---

    // 1. 静态嵌套类 (Static Nested Class)
    // 它与 Dictionary 的实例无关，是一个独立的工具类，只是碰巧定义在内部。
    public static class WordProperties {
        public static String getProperties(String word) {
            return String.format("'%s' | Length: %d, First Letter: %c",
                    word, word.length(), word.charAt(0));
        }
    }

    // 2. 内部类 (Inner Class)
    // 它依赖于 Dictionary 的实例，可以访问外部类的成员（虽然这里没用到）。
    public class WordSelector {
        public String selectFirstWordStartingWith(char letter) {
            for (String word : WORDS) { // 可以直接访问外部类的 static 成员 WORDS
                if (!word.isEmpty() && word.charAt(0) == letter) {
                    return word;
                }
            }
            return "No word found starting with '" + letter + "'.";
        }
    }

    // 一个工厂方法来创建内部类的实例
    public WordSelector getWordSelector() {
        return new WordSelector();
    }
}
