class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int[] reservedSeat : reservedSeats) {
            int row  = reservedSeat[0];
            int seat = reservedSeat[1];
            mp.merge(row, (1 << seat), (a, b) -> a | b);
        }
        int result = (n - mp.size()) * 2;

        int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int bookedSeatsMask = entry.getValue();

            boolean groupA = (bookedSeatsMask & maskA) == 0;
            boolean groupB = (bookedSeatsMask & maskB) == 0;
            boolean groupC = (bookedSeatsMask & maskC) == 0;

            if(groupA && groupC)
                result += 2;
            else if(groupA || groupB || groupC)
                result += 1;
        }
        return result;
    }
}