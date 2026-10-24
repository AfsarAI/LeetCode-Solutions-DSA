class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int arriveA = getDayOfYear(arriveAlice, daysInMonth);
        int leaveA = getDayOfYear(leaveAlice, daysInMonth);
        int arriveB = getDayOfYear(arriveBob, daysInMonth);
        int leaveB = getDayOfYear(leaveBob, daysInMonth);
        int overlapStart = Math.max(arriveA, arriveB);
        int overlapEnd = Math.min(leaveA, leaveB);
        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    private int getDayOfYear(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        return totalDays;
    }
}