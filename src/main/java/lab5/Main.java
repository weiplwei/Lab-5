package lab5;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java lab5.Main <command> [number]");
            System.out.println("Commands: concat, repeat, nth, reverse");
            return;
        }

        String command = args[0];
        int number = 0;
        if (args.length > 1) {
            try {
                number = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("The second argument must be an integer.");
                return;
            }
        }

        Dictionary dictionary = new Dictionary();

        Wordable wordable = (cmd, num) -> {
            StringJoiner sj = new StringJoiner(" ");
            switch (cmd) {
                case "concat":
                    for (String word : dictionary.getWords()) {
                        sj.add(word);
                    }
                    return sj.toString();
                case "repeat":
                    for (String word : dictionary.getWords()) {
                        for (int i = 0; i < num; i++) {
                            sj.add(word);
                        }
                    }
                    return sj.toString();
                case "nth":
                    if (num > 0 && num <= dictionary.getWords().size()) {
                        return dictionary.getWords().get(num - 1);
                    } else {
                        return "Invalid index for 'nth' command.";
                    }
                case "reverse":
                    for (String word : dictionary.getWords()) {
                        sj.add(Dictionary.reverseString(word));
                    }
                    return sj.toString();
                default:
                    return "Unknown command.";
            }
        };

        String result = dictionary.getWords(command, number, wordable);
        System.out.println("Result for command '" + command + "':");
        System.out.println(result);

        System.out.println("\n--- Method Reference Demonstrations ---");

        // 1. System.out::println to print all words
        System.out.println("\n1. Printing all words with System.out::println:");
        dictionary.getWords().forEach(System.out::println);

        // 2. Dictionary::reverseString to reverse and print each word
        System.out.println("\n2. Reversing each word with Dictionary::reverseString:");
        dictionary.getWords().stream()
                .map(Dictionary::reverseString)
                .forEach(System.out::println);

        // 3. Arrays.sort with Dictionary::alphabeticalOrder
        System.out.println("\n3. Sorting words with Dictionary::alphabeticalOrder:");
        String[] wordArray = dictionary.getWords().toArray(new String[0]);
        java.util.Arrays.sort(wordArray, Dictionary::alphabeticalOrder);
        System.out.println(java.util.Arrays.toString(wordArray));

        // 4. Filtering words with Dictionary::isLengthAboveN
        System.out.println("\n4. Filtering words with length > 5 using Dictionary::isLengthAboveN:");
        dictionary.getWords().stream()
                .filter(s -> Dictionary.isLengthAboveN(s, 5))
                .forEach(System.out::println);

        System.out.println("\n--- Nested Class Demonstrations ---");

        // 1. Static Nested Class
        System.out.println("\n1. Static Nested Class Demonstration:");
        System.out.println(Dictionary.WordProperties.getProperties("jabberwocky"));

        // 2. Inner Class
        System.out.println("\n2. Inner Class Demonstration:");
        Dictionary.WordSelector selector = dictionary.new WordSelector();
        System.out.println(selector.selectFirstWordStartingWith('j'));

        // 3. Local Class
        System.out.println("\n3. Local Class Demonstration:");
        demonstrateLocalClass(dictionary.getWords().get(0));

        // 4. Anonymous Class
        System.out.println("\n4. Anonymous Class Demonstration (shout command):");
        Wordable shoutable = new Wordable() {
            @Override
            public String createString(String input, int number) {
                StringJoiner sj = new StringJoiner(" ");
                for (String word : dictionary.getWords()) {
                    sj.add(word.toUpperCase() + "!");
                }
                return sj.toString();
            }
        };
        System.out.println(dictionary.getWords("shout", 0, shoutable));
    }

    public static void demonstrateLocalClass(String sampleWord) {
        // 3. Local Class (defined inside a method)
        class WordFormatter {
            private final String word;

            public WordFormatter(String word) {
                this.word = word;
            }

            public String format() {
                return "Formatted Word: ***" + word + "***";
            }
        }

        WordFormatter formatter = new WordFormatter(sampleWord);
        System.out.println(formatter.format());
    }
}