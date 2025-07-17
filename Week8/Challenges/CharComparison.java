public class CharComparison {
    /**
     * Given an array of char, determine if the array A belongs to the left or to the right of char array B lexigraphically.
     * That means its position in a dictionary, eg:
     * cat < dog < mouse
     * car < care < cat
     * You will need to compare an index of both arrays against each other as you iterate with a for loop.
     *
     * @param a an array of char.
     * @param b an array of char.
     * @return -1 if A is less than B, 1 if A is greater than B, and 0 if the two arrays are identical.
     */
    public int compare(char[] a, char[] b){
        int minLength = Math.min(a.length, b.length);

        for (int i = 0; i < minLength; i++) {
            if (a[i] < b[i]) {
                return -1;
            } else if (a[i] > b[i]) {
                return 1;
            }
        }

        //if all characters are equal, decide by length
        if (a.length < b.length) {
            return -1;
            } else if (a.length > b.length) {
            return 1;
            }
        return 0;
    }
}
