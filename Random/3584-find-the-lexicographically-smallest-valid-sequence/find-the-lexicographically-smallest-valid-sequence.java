class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];
        Arrays.fill(last, -1);
        for (int i = n - 1, j = m - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j--] = i;
            }
        }

        int[] res = new int[m];
        int j = 0;
        boolean changed = false;
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                res[j++] = i;
            }else if (!changed && (j == m - 1 || i < last[j + 1])) {
                res[j++] = i;
                changed = true;
            }
        }

        return j == m ? res : new int[0];
    }
}