class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int leftToRemove = 0;
        int rightToRemove = 0;
        
        // Step 1: Calculate minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToRemove++;
            } else if (c == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }

        // Step 2: Backtrack to generate valid combinations
        dfs(s, 0, leftToRemove, rightToRemove, res);
        return res;
    }

    private void dfs(String s, int start, int left, int right, List<String> res) {
        // When we've removed the target number of parentheses, check validity
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // Skip consecutive duplicates to avoid duplicate results
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char c = s.charAt(i);
            // Ignore lowercase English letters
            if (c != '(' && c != ')') {
                continue;
            }

            // Try removing a left parenthesis
            if (left > 0 && c == '(') {
                String nextStr = s.substring(0, i) + s.substring(i + 1);
                dfs(nextStr, i, left - 1, right, res);
            }
            
            // Try removing a right parenthesis
            if (right > 0 && c == ')') {
                String nextStr = s.substring(0, i) + s.substring(i + 1);
                dfs(nextStr, i, left, right - 1, res);
            }
        }
    }

    // Helper method to check if a string has valid parentheses
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            // A valid string can never have more closing brackets than opening ones at any point
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}