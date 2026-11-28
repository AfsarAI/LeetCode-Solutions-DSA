class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        long minPrice = Long.MAX_VALUE;
        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }
        int[] gainByFactor = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            int totalMultiples = 0;
            for (int m = f; m <= n; m += f) {
                totalMultiples += freq[m];
            }
            gainByFactor[f] = totalMultiples - 1;
        }

        List<long[]> val2Batches = new ArrayList<>();
        for (int[] item : items) {
            int g = gainByFactor[item[0]];
            if (g > 0) {
                val2Batches.add(new long[]{item[1], g});
            }
        }
        val2Batches.sort(Comparator.comparingLong(a -> a[0]));

        long rem = budget;
        long totalItems = 0;
        long lastTakenPrice = -1;

        for (long[] batch : val2Batches) {
            long price = batch[0];
            long count = batch[1];

            if (price > 2 * minPrice || price > rem) {
                break;
            }

            long canTake = Math.min(count, rem / price);
            if (canTake > 0) {
                rem -= canTake * price;
                totalItems += canTake * 2;
                lastTakenPrice = price;
            }
        }
        long best = totalItems + (rem / minPrice);
        if (lastTakenPrice != -1) {
            long altItems = (totalItems - 2) + ((rem + lastTakenPrice) / minPrice);
            best = Math.max(best, altItems);
        }

        return (int) best;
    }
}