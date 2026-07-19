class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (inStack[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                inStack[removed - 'a'] = false;
            }

            stack.append(ch);
            inStack[ch - 'a'] = true;
        }

        return stack.toString();
    }
}