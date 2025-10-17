package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <command> [number]");
            System.out.println("Commands: concat, repeat, nth, reverse");
            return;
        }

        Dictionary dictionary = new Dictionary();
        String command = args[0];
        // 如果有第二个参数，则解析为数字，否则默认为0
        int number = args.length > 1 ? Integer.parseInt(args[1]) : 0;

        // --- Part 3: Lambda Expressions ---
        System.out.println("--- Part 3: Lambda Expression Output ---");
        Wordable wordable = null;

        switch (command.toLowerCase()) {
            case "concat":
                // Lambda: 接收一个词 (w) 和一个数字 (n)，直接返回这个词
                wordable = (w, n) -> w;
                break;
            case "repeat":
                // Lambda: 接收一个词 (w) 和一个数字 (n)，返回重复n次的词
                wordable = (w, n) -> w.repeat(n);
                break;
            case "nth":
                // Lambda: 如果词的长度 >= n，返回第n个字符，否则返回空
                wordable = (w, n) -> (w.length() >= n && n > 0) ? String.valueOf(w.charAt(n - 1)) : "";
                break;
            case "reverse":
                // Lambda: 调用静态辅助方法来反转每个词
                wordable = (w, n) -> Dictionary.reverseString(w);
                break;
            default:
                System.out.println("Unknown command: " + command);
                return;
        }

        String result = dictionary.getWords(command, number, wordable);
        System.out.println("Result: " + result);
        System.out.println();

        // --- Part 4: Method References ---
        System.out.println("--- Part 4: Method References Demo ---");
        List<String> words = dictionary.getWordList();

        // 1. 使用 System.out::println 打印所有单词
        System.out.println("Printing all words:");
        words.forEach(System.out::println);

        // 2. 使用 Dictionary::reverseString 反转并打印每个词
        System.out.println("\nReversed words:");
        words.stream()
             .map(Dictionary::reverseString)
             .forEach(System.out::println);

        // 3. 使用 Dictionary::alphabeticalOrder 排序
        String[] wordsArray = words.toArray(new String[0]);
        Arrays.sort(wordsArray, Dictionary::alphabeticalOrder);
        System.out.println("\nSorted words (first 10): " + Arrays.toString(Arrays.copyOf(wordsArray, 10)));

        // 4. 使用 Dictionary::isLengthAboveN 过滤并打印长于10个字母的词
        System.out.println("\nWords longer than 10 letters:");
        words.stream()
             .filter(w -> Dictionary.isLengthAboveN(w, 10)) // Lambda形式调用
             .forEach(System.out::println);
        System.out.println();


        // --- Part 5: All 4 Nested Class Types Demo ---
        System.out.println("--- Part 5: Nested Classes Demo ---");
        // 1. Static Nested Class (静态嵌套类)
        System.out.println("Static Nested Class:");
        System.out.println(Dictionary.WordProperties.getProperties("example"));

        // 2. Inner Class (内部类)
        System.out.println("\nInner Class:");
        Dictionary.WordSelector selector = dictionary.getWordSelector();
        System.out.println("First word starting with 'j': " + selector.selectFirstWordStartingWith('j'));

        // 调用一个方法来演示 Local 和 Anonymous 类
        demonstrateLocalAndAnonymousClasses(words.get(0));
    }

    public static void demonstrateLocalAndAnonymousClasses(String sampleWord) {
        // 3. Local Class (局部类)
        // 定义在方法内部，只能在此方法中使用
        class VowelCounter {
            public int countVowels(String text) {
                int count = 0;
                for (char c : text.toLowerCase().toCharArray()) {
                    if ("aeiou".indexOf(c) != -1) {
                        count++;
                    }
                }
                return count;
            }
        }
        VowelCounter counter = new VowelCounter();
        System.out.println("\nLocal Class:");
        System.out.printf("Vowels in '%s': %d\n", sampleWord, counter.countVowels(sampleWord));

        // 4. Anonymous Class (匿名类)
        // 一个没有名字的、即时实现的类，通常用于实现接口或继承类
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is running inside an Anonymous Class!");
            }
        };
        System.out.println("\nAnonymous Class:");
        myRunnable.run();
    }
}
