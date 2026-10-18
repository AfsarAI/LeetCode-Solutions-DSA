import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final long MOD = 1_000_000_007;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Step 1: Precompute Pascal's triangle for combinations (nCr % MOD)
        combinations = new long[n][n];
        for (int i = 0; i < n; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }

        // Convert array to list for easier recursive filtering
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        // Step 2: Calculate total valid permutations, subtract 1 to exclude the original array
        return (int) ((dfs(numsList) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        // Base case: If 2 or fewer elements, there's only 1 valid configuration 
        // (1 root, and at most 1 child, or 1 root and 1 left + 1 right)
        if (nums.size() <= 2) {
            return 1;
        }

        // The first element is always the root
        int root = nums.get(0);
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();

        // Distribute remaining elements to left or right subtrees keeping their relative order
        for (int i = 1; i < nums.size(); i++) {
            int current = nums.get(i);
            if (current < root) {
                leftSubtree.add(current);
            } else {
                rightSubtree.add(current);
            }
        }

        // Recursively find the number of ways to form left and right subtrees
        long leftWays = dfs(leftSubtree);
        long rightWays = dfs(rightSubtree);

        // Calculate permutations for interleaving left and right subtrees
        int leftSize = leftSubtree.size();
        int rightSize = rightSubtree.size();
        long interleaveWays = combinations[leftSize + rightSize][leftSize];

        // Combine the results modulo 10^9 + 7
        return (leftWays * rightWays % MOD) * interleaveWays % MOD;
    }
}