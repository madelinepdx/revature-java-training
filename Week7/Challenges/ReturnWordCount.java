
public class ReturnWordCount {
    /**
     * @param in A String representing a sentence, with words delineated by spaces.
     * @return return the amount of words in a string.
     */
    public int count(String in){
        in = in.trim(); //remove spaces from start to end

        if (in.isEmpty()) return 0;

        String [] words = in.split(" ");
        int count = 0;

        for (String word : words) {
            if (!words.equals("")) {
                count++;
            }
        }
        return count;
    }
}
