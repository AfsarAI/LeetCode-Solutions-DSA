class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;

        k %= total;

        if (k != 0) {
            reverse(grid, 0, total - 1);
            reverse(grid, 0, k - 1);
            reverse(grid, k, total - 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                currentRow.add(grid[i][j]);
            }

            result.add(currentRow);
        }

        return result;
    }

    private void reverse(int[][] grid, int left, int right) {

        int cols = grid[0].length;

        while (left < right) {

            int leftRow = left / cols;
            int leftCol = left % cols;

            int rightRow = right / cols;
            int rightCol = right % cols;

            int temp = grid[leftRow][leftCol];
            grid[leftRow][leftCol] = grid[rightRow][rightCol];
            grid[rightRow][rightCol] = temp;

            left++;
            right--;
        }
    }
}