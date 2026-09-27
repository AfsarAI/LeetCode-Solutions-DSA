class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // 1. Pair up matching parentheses indices
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        // 2. Traverse and teleport across matching parentheses
        StringBuilder result = new StringBuilder();
        for (int i = 0, dir = 1; i < n; i += dir) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = pair[i]; // Jump to the matching parenthesis
                dir = -dir;  // Reverse traversal direction
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}