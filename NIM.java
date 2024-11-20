/*
 
 * Author: Chase Blodgett
 * */


public class NIM {

    /**
     * cerate a token array
     * @param size -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position will be the max value, each following
     * will be one smaller, with a minimum of 1.
     */
    public static int[] createTokenCounts(int size, int stickMax) {
        int [] tokenArray = new int[size];
        for(int i = 0; i < size; i++){
          tokenArray[i] = stickMax;
          if(stickMax > 1){
            stickMax--;
          }
        }
        return tokenArray; // you will want to delete this line.
    }

    /**
     * This provided function operators similarly to the python isDigit method. You give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design isn't hard, basically a linear search.
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This should check if the inputs are numbers
     * if those numbers are in the valid range.
     * @param tokenCount an array representing the number of tokens in each row.
     * @param row a string representing which row the user wants to take from. 1-indexed.
     * @param takes a string representing how many tokens the user wants to take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] tokenCount, String row, String takes) {
        if (isDigit(row) == false || isDigit(takes) == false){
          return false;
        }
        else{
          int intTakes = Integer.parseInt(takes);
          int intRow = Integer.parseInt(row);
          if (intRow > tokenCount.length|| intRow <= 0 || intTakes > 3 || intTakes < 1){
            return false;
          }
          else{
            if(tokenCount[intRow - 1] < intTakes){
              return false;
            }
          }
        }
        return true;
    }

    /**
     * User System.out.println to represent a token grid to the program user.
     * @param tokenCount an array representing the number of tokens in each row.
     */
    public static void drawBoard(int[] tokenCount) {
        System.out.println("Game board");
        System.out.println();
        System.out.println("====================");
        for(int i = 0; i < tokenCount.length; i++){
          System.out.print((i + 1) + " ");
          for(int j = 0; j < tokenCount[i];j++){
            System.out.print("$");
          }
          System.out.println();
        }
        System.out.println("====================");
    }


    /**
     * Create an updated version of the game state. You can assume the row and takes are valid for the tokenCount array provided.
     * @param tokenCount an array representing the number of tokens in each row.
     * @param row the row the user wants to take from (0-indexed)
     * @param takes the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after the given numbers were removed.
     */
    public static int[] update(int[] tokenCount, int row, int takes){
        int [] updatedBoard = tokenCount.clone();
        updatedBoard[row] = updatedBoard[row] - takes;
        return updatedBoard;
    }

    /**
     *
     * @param tokenCount an array representing the number of tokens in each row.
     * @return true if and only if every element of tokenCount is false.
     */
    public static boolean isOver(int[] tokenCount) {
        for(int i = 0; i < tokenCount.length; i++){
          if(tokenCount[i] > 0){
            return false;
          }
        }
        return true;
    }
}
