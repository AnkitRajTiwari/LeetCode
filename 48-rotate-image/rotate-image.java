class Solution {
    public void rotate(int[][] matrix) {
        // Step 1: Get the edge length of the square matrix
        int n = matrix.length;

        // Step 3: Transpose the matrix (swap across the main diagonal)
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }    

        // step 4
        // Step 3: Reverse the matrix vertically (top row <-> bottom row)
        for(int i=0;i<n;i++)
        {
            int start=0 ,end=n-1;
             while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }    
    }
}
 // so here first we have to traNSPOSE AND THEN REVERSE as we have to rotate the matrix by 90  degree clockwise.. 
 // Did reverse first and then transpose → Resulted in 90° anti-clockwise rotation.
 //Correct approach:

 // First transpose, then reverse each row → Results in 90° clockwise rotation.

// using two pointer and the swapping method and the tranpose method 

//}

// for the rotation of the imageb
// 1) swap it 
// 2) for the diagonal element tranpose it 