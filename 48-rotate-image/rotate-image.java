class Solution {
    public void rotate(int[][] matrix) {
        // Step 1: Get the edge length of the square matrix
        int edgeLength = matrix.length;

        // Step 2: Initialize pointers for top and bottom rows
        int top = 0;
        int bottom = edgeLength - 1;

        // Step 3: Reverse the matrix vertically (top row <-> bottom row)
        while (top < bottom) {
            for (int col = 0; col < edgeLength; col++) {
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;
            }
            top++;
            bottom--;
        }

        // Step 4: Transpose the matrix (swap across the main diagonal)
        for (int row = 0; row < edgeLength; row++) {
            for (int col = row + 1; col < edgeLength; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }        
    }
}
