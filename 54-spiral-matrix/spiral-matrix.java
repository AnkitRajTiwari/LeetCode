import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Get number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Starting position: top-left corner
        int x = 0;  // column index
        int y = 0;  // row index

        // Initial direction: moving right (dx = 1 means move in +x direction)
        int dx = 1;
        int dy = 0;

        // List to store the elements in spiral order
        List<Integer> res = new ArrayList<>();

        // Loop exactly rows * cols times (once for each element in the matrix)
        for (int i = 0; i < rows * cols; i++) {
            // Add current element to result list
            res.add(matrix[y][x]);

            // Mark current cell as visited with a value outside the valid range (-101)
            matrix[y][x] = -101;

            // Check if next position is within bounds and not visited
            if (!(0 <= x + dx && x + dx < cols && 0 <= y + dy && y + dy < rows)
                || matrix[y + dy][x + dx] == -101) {
                
                // Rotate direction 90 degrees clockwise:
                // (dx, dy) → (-dy, dx)
                int temp = dx;
                dx = -dy;
                dy = temp;
            }

            // Move to the next position in the current direction
            x += dx;
            y += dy;
        }

        // Return the final spiral order list
        return res;
    }
}
