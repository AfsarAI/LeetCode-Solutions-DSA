class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        int n = occupiedIntervals.length;
        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> merge = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = occupiedIntervals[i][0];
            int end = occupiedIntervals[i][1];
            int j = i + 1;
            while (j < n &&
                   occupiedIntervals[j][0] - end <= 1) {
                end = Math.max(end, occupiedIntervals[j][1]);
                j++;
            }
            merge.add(Arrays.asList(start, end));
            i = j;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> interval : merge) {
            int start = interval.get(0);
            int end = interval.get(1);
            if (end < freeStart) {
                ans.add(Arrays.asList(start, end));
            }else if (start > freeEnd) {
                ans.add(Arrays.asList(start, end));
            }else {
                if (start < freeStart) {
                    ans.add(Arrays.asList(start, freeStart - 1));
                }
                if (end > freeEnd) {
                    ans.add(Arrays.asList(freeEnd + 1, end));
                }
            }
        }
        return ans;
    }
}