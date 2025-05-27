class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> c_X = new HashMap<>();
        Map<Integer, List<Integer>> c_Y = new HashMap<>();
        Set<Integer> buildingCoordinates = new HashSet<>();

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            c_X.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            c_Y.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            buildingCoordinates.add(x * (n + 1) + y);
        }

        for (int x : c_X.keySet()) {
            Collections.sort(c_X.get(x));
        }
        for (int y : c_Y.keySet()) {
            Collections.sort(c_Y.get(y));
        }

        int coveredCount = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            boolean left = false;
            if (c_Y.containsKey(y)) {
                List<Integer> xList = c_Y.get(y);
                int index = Collections.binarySearch(xList, x);
                if (index > 0) {
                    left = true;
                }
            }

            boolean right = false;
            if (c_Y.containsKey(y)) {
                List<Integer> xList = c_Y.get(y);
                int index = Collections.binarySearch(xList, x);
                if (index < xList.size() - 1) {
                    right = true;
                }
            }

            boolean above = false;
            if (c_X.containsKey(x)) {
                List<Integer> yList = c_X.get(x);
                int index = Collections.binarySearch(yList, y);
                if (index < yList.size() - 1) {
                    above = true;
                }
            }

            boolean below = false;
            if (c_X.containsKey(x)) {
                List<Integer> yList = c_X.get(x);
                int index = Collections.binarySearch(yList, y);
                if (index > 0) {
                    below = true;
                }
            }

            if (left && right && above && below) {
                coveredCount++;
            }
        }

        return coveredCount;
    }
}