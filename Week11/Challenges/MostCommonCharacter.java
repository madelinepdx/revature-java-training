
import java.util.HashMap;

public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */
    public char recurringChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char maxChar = ' ';
        int maxCount = 0;

        for (char c: str.toCharArray()) {
            int count = map.getOrDefault (c, 0) + 1;
            map.put(c, count);
            if (count > maxCount) {
                maxCount = count;
                maxChar = c;
            }
        }
        return maxChar;
    }
}
