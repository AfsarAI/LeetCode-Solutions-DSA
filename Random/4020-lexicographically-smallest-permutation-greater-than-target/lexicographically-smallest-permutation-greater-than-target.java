class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] total = new int[26];

        for (char c : s.toCharArray()) {
            total[c - 'a']++;
        }

        // need = frequency of target[0 ... i-1]
        int[] need = new int[26];

        // Initially target[0 ... n-1] is in need
        for (char c : target.toCharArray()) {
            need[c - 'a']++;
        }

        // Try to make the first difference as far right as possible
        for (int i = n - 1; i >= 0; i--) {

            // Remove target[i]
            // Now need represents target[0 ... i-1]
            int cur = target.charAt(i) - 'a';
            need[cur]--;

            // Check whether target[0 ... i-1] can be formed from s
            boolean possible = true;

            for (int c = 0; c < 26; c++) {
                if (need[c] > total[c]) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            // Find smallest available character
            // that is greater than target[i]
            for (int c = cur + 1; c < 26; c++) {

                if (total[c] > need[c]) {

                    StringBuilder ans = new StringBuilder();

                    // Keep prefix same as target
                    ans.append(target, 0, i);

                    // Make it strictly greater here
                    ans.append((char) ('a' + c));

                    // Remaining characters
                    int[] remaining = total.clone();

                    // Remove prefix
                    for (int j = 0; j < i; j++) {
                        remaining[target.charAt(j) - 'a']--;
                    }

                    // Remove chosen character
                    remaining[c]--;

                    // Put remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (remaining[x] > 0) {
                            ans.append((char) ('a' + x));
                            remaining[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}