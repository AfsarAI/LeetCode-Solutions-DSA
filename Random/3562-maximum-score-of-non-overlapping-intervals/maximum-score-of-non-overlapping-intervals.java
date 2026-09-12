class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        // Store original index
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by ending point
        Arrays.sort(arr, (a, b) -> {
            if (a.r != b.r)
                return Integer.compare(a.r, b.r);

            return Integer.compare(a.l, b.l);
        });

        // prev[i] = last interval before i
        // whose end < current start
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }

        /*
            dp[i][k] =
            best answer using first i intervals
            and choosing at most k intervals
        */
        State[][] dp = new State[n + 1][5];

        // Base case:
        // choosing 0 intervals gives score 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }

        // Base case:
        // no intervals available
        for (int k = 0; k <= 4; k++) {
            dp[0][k] = new State(0, new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {

            Interval cur = arr[i - 1];

            for (int k = 1; k <= 4; k++) {

                // 1. Don't take current interval
                State notTake = dp[i - 1][k];

                // 2. Take current interval
                State previous = dp[prev[i - 1] + 1][k - 1];

                List<Integer> list =
                    new ArrayList<>(previous.indices);

                list.add(cur.idx);

                // Answer must be sorted by original index
                Collections.sort(list);

                State take = new State(
                    previous.score + cur.w,
                    list
                );

                dp[i][k] = better(notTake, take);
            }
        }

        return dp[n][4].indices
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }


    // Find the last interval j < i
    // such that arr[j].r < arr[i].l
    static int findPrevious(Interval[] arr, int i) {

        int lo = 0;
        int hi = i - 1;

        int ans = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid].r < arr[i].l) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }


    // Return the better state
    static State better(State a, State b) {

        if (a.score > b.score)
            return a;

        if (b.score > a.score)
            return b;

        // Same score:
        // lexicographically smaller indices
        if (isSmaller(a.indices, b.indices))
            return a;

        return b;
    }


    static boolean isSmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}