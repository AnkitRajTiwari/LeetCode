class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[] top           = null; 
        int[] topRight      = null;
        int[] right         = null;
        int[] bottomRight   = null;
        int[] bottom        = null;
        int[] bottomLeft    = null; 
        int[] left          = null; 
        int[] topLeft       = null;

        for (int[] q : queens) {
            left    = q[0] == king[0] && q[1] < king[1] && (left    == null || q[1] > left[1])      ? q : left;
            right   = q[0] == king[0] && q[1] > king[1] && (right   == null || q[1] < right[1])     ? q : right;
            top     = q[1] == king[1] && q[0] < king[0] && (top     == null || q[0] > top[0])       ? q : top;
            bottom  = q[1] == king[1] && q[0] > king[0] && (bottom  == null || q[0] < bottom[0])    ? q : bottom;

            boolean isDiagonal = Math.abs(king[0] - q[0]) == Math.abs(king[1] - q[1]);

            topLeft     = isDiagonal && q[0] < king[0] && q[1] < king[1] && (topLeft        == null || (q[0] > topLeft[0]       && q[1] > topLeft[1]))      ? q : topLeft;
            bottomRight = isDiagonal && q[0] > king[0] && q[1] > king[1] && (bottomRight    == null || (q[0] < bottomRight[0]   && q[1] < bottomRight[1]))  ? q : bottomRight;
            bottomLeft  = isDiagonal && q[0] > king[0] && q[1] < king[1] && (bottomLeft     == null || (q[0] < bottomLeft[0]    && q[1] > bottomLeft[1]))   ? q : bottomLeft;
            topRight    = isDiagonal && q[0] < king[0] && q[1] > king[1] && (topRight       == null || (q[0] > topRight[0]      && q[1] < topRight[1]))     ? q : topRight;
        }

        var res = new ArrayList<List<Integer>>();

        if (top         != null) res.add(List.of(top[0],            top[1]));
        if (topRight    != null) res.add(List.of(topRight[0],       topRight[1]));
        if (right       != null) res.add(List.of(right[0],          right[1]));
        if (bottomRight != null) res.add(List.of(bottomRight[0],    bottomRight[1]));
        if (bottom      != null) res.add(List.of(bottom[0],         bottom[1]));
        if (bottomLeft  != null) res.add(List.of(bottomLeft[0],     bottomLeft[1]));
        if (left        != null) res.add(List.of(left[0],           left[1]));
        if (topLeft     != null) res.add(List.of(topLeft[0],        topLeft[1]));

        return res;
    }
}