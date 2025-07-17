
import java.util.List;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums){
        int Max1 = Integer.MIN_VALUE;
        int Max2 = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > Max1) {
                Max2 = Max1;
                Max1 = num;
            } else if (num > Max2 || num == Max1) {
                Max2 = num;
            }
        }
        return Max1 + Max2;
    }
}