/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode temp = head.next;

        int first = 0;
        int last = 0;
        int prevInd = 0;
        int ind = 2;

        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MIN_VALUE;

        int cnt = 0;

        while (temp != null && temp.next != null) {
            if ((temp.val > prev.val && temp.val > temp.next.val) ||
                (temp.val < prev.val && temp.val < temp.next.val)) {
                if (first == 0) {
                    first = ind;
                    last = first;
                    cnt++;
                } else {
                    prevInd = last;
                    last = ind;
                    cnt++;
                    ans[0] = Math.min(ans[0], last - prevInd);
                }
            }

            ans[1] = Math.max(ans[1], last - first);
            ind++;
            prev = temp;
            temp = temp.next;
        }

        if (cnt < 2) {
            return new int[] { -1, -1 };
        }
        return ans;
    }
}