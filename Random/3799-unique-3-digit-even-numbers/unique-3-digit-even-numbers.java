class Solution {

    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int unique = 0;

        // Non-zero digits grouped by frequency
        int single = 0;       // frequency = 1
        int multiple = 0;     // frequency >= 2

        // Even non-zero digits grouped by frequency
        int evenSingle = 0;
        int evenDouble = 0;
        int evenMultiple = 0;

        for (int d = 0; d <= 9; d++) {

            if (freq[d] > 0) {
                unique++;
            }

            if (d != 0) {

                if (freq[d] == 1) {
                    single++;

                    if (d % 2 == 0) {
                        evenSingle++;
                    }

                } else if (freq[d] == 2) {
                    multiple++;

                    if (d % 2 == 0) {
                        evenDouble++;
                    }

                } else if (freq[d] >= 3) {
                    multiple++;

                    if (d % 2 == 0) {
                        evenMultiple++;
                    }
                }
            }
        }

        int ans = 0;

        /*
         * Case 1:
         * Last digit = 0
         */
        if (freq[0] > 0) {

            int u = unique;

            // If there was only one zero,
            // that zero disappears after using it.
            if (freq[0] == 1) {
                u--;
            }

            ans += multiple * u
                 + single * (u - 1);
        }


        /*
         * Case 2:
         * Last digit = an even non-zero digit
         *
         * Frequency = 1
         */
        int u1 = unique - 1;
        int s1 = single - 1;
        int m1 = multiple;

        ans += evenSingle *
               (m1 * u1 + s1 * (u1 - 1));


        /*
         * Frequency = 2
         *
         * After using one copy:
         * frequency 2 -> frequency 1
         */
        int u2 = unique;
        int s2 = single + 1;
        int m2 = multiple - 1;

        ans += evenDouble *
               (m2 * u2 + s2 * (u2 - 1));


        /*
         * Frequency >= 3
         *
         * After using one copy,
         * it is still a multiple-copy digit.
         */
        int u3 = unique;
        int s3 = single;
        int m3 = multiple;

        ans += evenMultiple *
               (m3 * u3 + s3 * (u3 - 1));

        return ans;
    }
}