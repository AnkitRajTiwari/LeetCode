class Solution {
    public double totalAreaBelow(int [][]squares, double mid)
    {
        int n = squares.length;
        double area = 0.0;
        for(int i=0;i<n;i++)
            {
                //if the whole square is below the line, then calculate the whole area.
                //else if some part of square is there below and above the mid then get the partial height and get the area
                if((double)squares[i][2] + (double)squares[i][1] <= mid)
                {
                    area += (double)squares[i][2] * (double)squares[i][2];
                }
                else if((double)squares[i][2] + (double)squares[i][1] > mid && mid>(double)squares[i][1])
                {
                    double h = mid - (double)squares[i][1];
                    area += (h*squares[i][2]);
                }
            }
        return area;
        
    }
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double totArea = 0;
        int maxHeight = 0;
        for(int i=0;i<n;i++)
            {
                totArea += ((double)squares[i][2]*(double)squares[i][2]);
                maxHeight = Math.max(maxHeight, squares[i][2]+squares[i][1]);
            }
        double start = 0.0;
        double end = (double)maxHeight;
        while(start<end)
            {
                double mid = start + (end-start)/2;
                double areaBelow = totalAreaBelow(squares,mid);
                if(areaBelow >= totArea/2)
                {
                    end = mid-0.00001;
                }
                else
                {
                    start = mid+0.00001;
                }
            }
        return start;
    }
}