

public class Lab {
    /**
     *
     * Let's try writing a for loop at the 'code here' point...
     *      for loops have several parts, which follow the syntax
     *          for(1; 2; 3;){
     *              //code running inside loop
     *          }
     *      1. we declare some variable (by convention, called i, j, or k)
     *      2. we define a condition that must be met for the code within the block to run (usually to do with the variable)
     *      3. we define some operation that happens at the end of that block (usually incrementing/decrementing i).
     *
     *      in practice, that would look like
     *          for(int i = 0; i < 8; i++){
     *              System.out.print(i);
     *          }
     *          which prints out:
     *          01234567
     *          notice that i is a variable that can be accessed from inside the loop, that i=0 is inclusive,
     *          but the i<8 is exclusive, and that i++ allows i to be incremented *after* all the code inside the loop
     *          runs.
     *
     *      let's try it, at the "code here" point, write:
     *      for part 1, write
     *          int i = start;
     *      for part 2, write
     *          i < end;
     *      for part 3, write
     *          i++
     *      within the for loop block, let's have the following code:
     *          buildingString = buildingString + i + " ";
     *      This will concatenate the current value of i to an already existing variable 'buildingString', so that after the loop ends,
     *      we'll have a String containing every value of i separated by a space.
     * 
     *      You can consult any for loop example to resolve syntax issues.
     *
     *      @param start the value of i where the for loop should start.
     *      @param end the value of i where the for loop should end (provided that the for loop is incremented with i++)
     *      @return the string of all numbers between start and end, back-to-back. The string is inclusive of start and exclusive of end.
     */
    public String returnNumbers(int start, int end){
        String buildingString = "";

         for (int i = start; i < end; i++) {
            buildingString = buildingString + i + " ";
    }
        return buildingString;
    }
}