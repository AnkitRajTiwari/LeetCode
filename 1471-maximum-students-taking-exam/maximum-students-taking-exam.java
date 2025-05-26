class Solution {
    public int maxStudents(char[][] seats) {
        int rows = seats.length;
        int cols = seats[0].length;

        // we can have 2^n-1 different states(seats combinations)
        int states = 1 << cols;

        int[][] dp = new int[rows + 1][states];

        for (int row = 1; row <= rows; row++) {

            // convert available seats to binary representation
            int currSeats = currentSeatsBinary(row, seats);

            // status - the status for current row
            for (int state = 0; state < states; state++) {

                // currState - the valid state for current row
                int currState = state & currSeats;

                // determine whether currState satisfies the condition
                // that no students sit next to each other
                if ((currState & (currState >> 1)) > 0
                        || (currState & (currState << 1)) > 0) {
                    // we cannot place students in this case
                    continue;
                }

                int countMax = 0;
                // k - the state for previous row
                for (int k = 0; k < states; k++) {
                    // check diagonals so that
                    // there is no conflict with previous row
                    if (((k >> 1) & currState) == 0 
                         && ((k << 1) & currState) == 0) {
                        
                        // for valid case define the max count
                        int count = dp[row - 1][k] + Integer.bitCount(currState);
                        countMax = Math.max(countMax, count);
                    }
                }

                dp[row][currState] = countMax;
            }
        }

        // define max count of students in the last dp row
        int maxStudents = 0;
        for (int state = 0; state < states; state++) {
            maxStudents = Math.max(maxStudents, dp[rows][state]);
        }

        return maxStudents;
    }

    private int currentSeatsBinary(int row, char[][] seats) {
        char[] currentSeats = seats[row - 1];
        int currentSeatsBinary = 0;
        for (int c = 0; c < currentSeats.length; c++) {
            if (seats[row - 1][c] == '.') {
                currentSeatsBinary |= (1 << c);
            }
        }
        return currentSeatsBinary;
    }
}