class Solution {
    public boolean validTicTacToe(String[] board) {
        int numX = 0;
        int numO = 0;

        for (String s : board) {
            for (char ch : s.toCharArray()) {
                if (ch == 'X')
                    numX++;
                else if (ch == 'O')
                    numO++;
            }
        }
        if(numX < numO) return false;
        if (!(numX - numO == 1 || numX == numO))
            return false;

        boolean winO = checkWin(board, 'O');
        boolean winX = checkWin(board, 'X');

        if (winX && winO)
            return false;
        if (winX && numX - numO != 1)
            return false;
        if (winO && numX - numO != 0)
            return false;

        return true;
    }

    public boolean checkWin(String[] board, char ch) {
        for (String s : board) {
            if (s.charAt(0) == ch && s.charAt(1) == ch && s.charAt(2) == ch)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch)
                return true;
        }

        if ((board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch)
                || (board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch))
            return true;

        return false;
    }
}