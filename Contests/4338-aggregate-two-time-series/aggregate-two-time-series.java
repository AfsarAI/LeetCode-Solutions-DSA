class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int m = series1.length;
        int n = series2.length;
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m || j < n){
            int currTime = (i < m && j < n) ? Math.min(series1[i][0], series2[j][0]) : (i < m && j >= n) ? series1[i][0] : series2[j][0];
            int sum = (i < m && j < n) ? (series1[i][1] + series2[j][1]) : (i < m && j >= n) ? series1[i][1] : series2[j][1];
            ans.add(Arrays.asList(currTime, sum));
            if (i < m && series1[i][0] == currTime)
                i++;
            if (j < n && series2[j][0] == currTime)
                j++;          
        }
        return ans;
    }
}