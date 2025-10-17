Lab 5
Nested Classes, Lambda Expressions, and Method References

🔍 What You’ll Learn
•	How to write and use the four types of nested classes in Java: static, inner, local, anonymous
•	How to write and apply lambda expressions using functional interfaces
•	How to use method references to simplify your code

🧠 Part 1 — Functional Interface: Wordable
Create this interface:

@FunctionalInterface
public interface Wordable {
    String createString(String input, int number);
}
📚 Part 2 — Dictionary Class
- Create a class called Dictionary that stores a List<String> using the words at the bottom of this document.
- Include this method:
  public String getWords(String command, int number, Wordable w)
- Add these static helper methods:
  public static String reverseString(String s)
  public static int alphabeticalOrder(String a, String b)
  public static boolean isLengthAboveN(String s, int n)
💥 Part 3 — Main Class
In your Main class:
- Read command-line args (args[0] and optionally args[1])
- Use a lambda or class expression to implement Wordable based on the command:
    - 'concat': return all words joined together
    - 'repeat': repeat each word n times before joining
    - 'nth': return the nth word
    - 'reverse': return all words joined but individually reversed
- Call getWords() and print the result
🌲 Part 4 — Method References
In your main():
•	Use System.out::println to print all words
•	Use Dictionary::reverseString to reverse and print each word
•	Use Arrays.sort(words, Dictionary::alphabeticalOrder) to sort
•	Filter and print words longer than 5 letters using Dictionary::isLengthAboveN
🧬 Part 5 — All 4 Nested Class Types
Show each of these in action:
•	Static nested class
•	Inner class
•	Local class (inside a method)
•	Anonymous class (inline)
✅ Submission Checklist
Make sure you:
•	Use all 4 types of nested classes
•	Define and use a lambda expression
•	Use at least 3 method references
•	Have output that depends on args
•	Use the full provided word list
📃 Word List
jab, jabbed, jabber, jabbered, jabbering, jabbers, jabberwocky, jabbing, jabot, jabots
jabs, jacaranda, jacarandas, jacinth, jack, jackal, jackals, jackanapes, jackanapeses, jackass
jackasses, jackboot, jackboots, jackdaw, jackdaws, jacked, jacket, jacketed, jacketing, jackets
jackhammer, jackhammers, jackie, jacking, jackknife, jackpot, jackpots, jacks, jackson, jacksonville
jaclyn, jacob, jacobean, jacobian, jacobin, jacobins, jacobite, jacobites, jacobs, jacquard
jacquards, jacqueline, jacques, jactitation, jactitations, jactus, jacuzzi, jacuzzis, jade, jaded
jadeite, jadeites, jades, jading, jaeger, jaffa, jag, jagged, jaggedly, jaggedness
jagger, jags, jaguar, jaguars, jai, jail, jailed, jailer, jailers, jailhouse
jailing, jailor, jailors, jails, jaipur, jakarta, jake, jalopies, jalopy, jalousie
jalousies, jam, jamaica, jamaican, jamaicans, jamb, jamboree, jamborees, jambs, james
jamey, jamie, jammed, jamming, jammy, jams, jan, jane, janeiro, janet
jangle, jangled, jangles, jangling, janice, janitor, janitorial, janitors, january, januarys
janus, japan, japanese, japanned, japanning, japans, jape, japed, japer, japers
japery, japes, japing, japonica, japonicas, jar, jardiniere, jardinieres, jarful, jarfuls
jargon, jargons, jarred, jarring, jarringly, jarrow, jars, jasmine, jasmines, jason
jasper, jaspers, jaundice, jaundiced, jaunt, jaunted, jauntier, jauntiest, jauntily, jaunting
jaunts, jaunty, java, javanese, javelin, javelins, jaw, jawbone, jawbones, jawboning
jawbreaker, jawbreakers, jawed, jawing, jaws, jay, jays, jayvees, jaywalk, jaywalked
jaywalker, jaywalkers, jaywalking, jaywalks, jazz, jazzed, jazzes, jazzier, jazziest, jazzing
jazzman, jazzmen, jazzy, Examples for requirements f-g-h:, public class Dictionary {, // Assuming other existing methods and properties..., // Method for reversing a string (Task f: String Manipulation), public static String reverseString(final String s) {, return new StringBuilder(s).reverse().toString();, }
// Method for sorting words in alphabetical order (Task g: Array Operations), public static int alphabeticalOrder(final String word1, final String word2) {, return word1.compareTo(word2);, }, // Method for checking if word length is above five (Task h: Conditional Operations), public static boolean isLengthAboveFive(final String word) {, return word.length() > 5;, }, }, …and to call these from main()…
// Task f: Apply reverseString method reference to each word and print, for (String word : words) {, String reversed = Dictionary::reverseString;, System.out.println(reversed);, }, // Task g: Sort words using the alphabeticalOrder method reference, Arrays.sort(words, Dictionary::alphabeticalOrder);, System.out.println("Sorted words: " + Arrays.toString(words));, // Task h: Print words longer than five characters using method references, for (String word : words) {
if (Dictionary.isLengthAboveFive(word)) {, System.out.println(word); // or use System.out::println directly in a method call, }, }
