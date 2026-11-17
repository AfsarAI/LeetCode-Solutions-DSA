class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] modify = new int[n][n];
        List<List<Integer>> divisors = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            divisors.add(new ArrayList<>());
            for (int d = 1; d < i; d++) {
                if (i % d == 0) {
                    divisors.get(i).add(d);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int minChanges = Integer.MAX_VALUE;
                for (int d : divisors.get(len)) {
                    int currentChanges = 0;
                    for (int offset = 0; offset < d; offset++) {
                        int left = 0;
                        int right = len / d - 1;
                        while (left < right) {
                            if (s.charAt(i + offset + left * d) != s.charAt(i + offset + right * d)) {
                                currentChanges++;
                            }
                            left++;
                            right--;
                        }
                    }
                    minChanges = Math.min(minChanges, currentChanges);
                }
                modify[i][j] = minChanges;
            }
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 1_000_000_000); 
        }

        dp[0][0] = 0;
        for (int c = 1; c <= k; c++) {
            for (int p = c * 2; p <= n; p++) {
                for (int m = (c - 1) * 2; m <= p - 2; m++) {
                    if (dp[c - 1][m] != 1_000_000_000) {
                        dp[c][p] = Math.min(dp[c][p], dp[c - 1][m] + modify[m][p - 1]);
                    }
                }
            }
        }

        return dp[k][n];
    }
}