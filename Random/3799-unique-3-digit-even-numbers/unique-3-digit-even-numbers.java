class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of every digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int ans = 0;

        // 1. Choose the last digit
        // It must be even
        for (int last = 0; last <= 8; last += 2) {

            if (freq[last] == 0)
                continue;

            freq[last]--;  // use one copy of last digit

            // 2. Choose the first digit
            // It cannot be 0
            for (int first = 1; first <= 9; first++) {

                if (freq[first] == 0)
                    continue;

                freq[first]--;  // use one copy

                // 3. Choose the middle digit
                for (int middle = 0; middle <= 9; middle++) {

                    if (freq[middle] > 0) {
                        ans++;
                    }
                }

                freq[first]++;  // restore first digit
            }

            freq[last]++;  // restore last digit
        }

        return ans;
    }
}